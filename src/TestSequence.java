import java.util.*;

public class TestSequence {

    // Class variabels
    private static final int TEST_LENGTH = 1 * 500; // 20 * 1000
    private static final int TEST_ITERATIONS = 2; // 20

    // Instance variables
    private final String name;
    private final String version;
    private final CollectionToTest collection;
    private final int numberOfThreads;
    private final int elements;
    private final int readPercent;
    private final int updatePercent;
    private final int iteratePercent;
    private final Observer observer;

    private final List<Integer> startCollection;
    private Tester[] testers;
    private Thread[] threads;

    // Constructors
    private TestSequence(String name, String version, CollectionToTest collection, int numberOfThreads, int elements, int readPercent, int updatePercent, int iteratePercent, Observer observer) {
        this.name = name;
        this.version = version;
        this.collection = collection;
        this.numberOfThreads = numberOfThreads;
        this.elements = elements;
        this.readPercent = readPercent;
        this.updatePercent = updatePercent;
        this.iteratePercent = iteratePercent;
        this.observer = observer;

        this.startCollection = createStartingCollection();
        this.testers = createTester();
        this.threads = createThreads();

        runTest();
    }

    // Methods
    public static void queue(int numberOfThreads, int elements, int readPercent, int updatePercent, int iteratePercent, Observer observer) {
        new TestSequence("Queue", System.getProperty("java.version"), new QueueToTest(), numberOfThreads, elements, readPercent, updatePercent, iteratePercent, observer);
    }
    public static void list(int numberOfThreads, int elements, int readPercent, int updatePercent, int iteratePercent, Observer observer) {
        new TestSequence("List", System.getProperty("java.version"), new ListToTest(), numberOfThreads, elements, readPercent, updatePercent, iteratePercent, observer);
    }
    public static void hashMap(int numberOfThreads, int elements, int readPercent, int updatePercent, int iteratePercent, Observer observer) {
        new TestSequence("HashMap", System.getProperty("java.version"), new HashMapToTest(), numberOfThreads, elements, readPercent, updatePercent, iteratePercent, observer);
    }
    public static void treeMap(int numberOfThreads, int elements, int readPercent, int updatePercent, int iteratePercent, Observer observer) {
        new TestSequence("TreeMap", System.getProperty("java.version"), new TreeMapToTest(), numberOfThreads, elements, readPercent, updatePercent, iteratePercent, observer);
    }

    private List<Integer> createStartingCollection() {
        List<Integer> startingCollection = new ArrayList<>(elements);
        for (int i = 0; i < elements; i++) {
            startingCollection.add(i);
        }
        return startingCollection;
    }
    private Tester[] createTester() {
        Tester[] testers = new Tester[numberOfThreads];
        for (int i = 0; i < testers.length; i++) {
            testers[i] = new Tester(readPercent, updatePercent, iteratePercent, collection);
        }
        return testers;
    }
    private Thread[] createThreads() {
        Thread[] threads = new Thread[numberOfThreads];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(testers[i]);
        }
        return threads;
    }
    private List<Integer> getRandomStart() {
        Collections.shuffle(startCollection);
        return startCollection;
    }

    private void runTest() {
        System.out.print("TEST START ("+collection+" "+version+" "+numberOfThreads+" "+elements+" "+readPercent+"-"+updatePercent+"-"+iteratePercent+") ... ");
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            int totalOperations = 0;
            collection.fillCollection(getRandomStart());

            try {
                for (Thread thread : threads) {
                    thread.start();
                }
                Thread.sleep(TEST_LENGTH);
                for (Thread thread : threads) {
                    thread.interrupt();
                }
                for (Thread thread : threads) {
                    thread.join();
                }
            } catch (InterruptedException ignored) {}

            for (Tester tester : testers) {
                totalOperations += tester.getOperations();
            }

            observer.saveResult(new TestResult(name, version, numberOfThreads, elements, readPercent, updatePercent, iteratePercent, totalOperations));
            collection.resetCollection();

            testers = createTester();
            threads = createThreads();

            System.gc();
        }
        System.out.println("DONE");
    }

}
