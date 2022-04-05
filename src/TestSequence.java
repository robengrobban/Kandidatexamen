import java.util.*;

public abstract class TestSequence {

    // Class variabels
    protected static final int SIZE_OFFSET = 10;
    private static final int WARM_UP_ITERATIONS = 12000;
    private static final int TEST_LENGTH = 500; // 20 * 1000
    private static final int TEST_ITERATIONS = 1; // 20

    // Instance variables
    private final String name;
    private final String version;
    private final int numberOfThreads;
    private final int elements;
    private final int readPercent;
    private final int updatePercent;
    private final int iteratePercent;
    private Tester[] testers;
    private Thread[] threads;
    private final CollectionToTest collection;

    private final Observer observer;

    // Constructors
    public TestSequence(String name, String version, int numberOfThreads, int elements, int readPercent, int updatePercent, int iteratePercent, Observer observer) {
        this.name = name;
        this.version = version;
        this.numberOfThreads = numberOfThreads;
        this.elements = elements;
        this.readPercent = readPercent;
        this.updatePercent = updatePercent;
        this.iteratePercent = iteratePercent;
        this.observer = observer;

        this.collection = createCollectionToTest();
        this.testers = createTester();
        this.threads = createThreads();

        warmUpTest();
        runTest();
    }

    // Methods
    abstract protected CollectionToTest createCollectionToTest();

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

    private List<Integer> getRandomCollection() {
        List<Integer> values = new ArrayList<>(elements);
        for (int i = 0; i < elements; i++) {
            values.add(elements);
        }
        Collections.shuffle(values);
        return values;
    }

    private void warmUpTest() {
        collection.fillCollection(getRandomCollection());

        for (int i = 0; i < WARM_UP_ITERATIONS; i++) {
            collection.readOperation();
            collection.updateOperation();
            collection.iterateOperation();
        }

        collection.resetCollection();
        System.gc();
    }

    private void runTest() {
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            int totalOperations = 0;
            collection.fillCollection(getRandomCollection());

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
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            for (Tester tester : testers) {
                totalOperations += tester.getOperations();
            }

            observer.saveResult(new TestResult(name, version, numberOfThreads, elements, readPercent, updatePercent, iteratePercent, totalOperations));
            collection.resetCollection();

            testers = createTester();
            threads = createThreads();

            System.gc();
        }
    }

}
