import java.util.*;

public abstract class TestSequence {

    // Class variabels
    private static final int WARM_UP_ITERATIONS = 12000;
    private static final int TEST_LENGTH = 20;
    private static final int TEST_ITERATIONS = 20;

    // Instance variables
    private final int numberOfThreads;
    private final int readPercent;
    private final int updatePercent;
    private final int iteratePercent;
    private final Tester[] testers;
    private final Thread[] threads;
    private final CollectionToTest collection;

    private int totalOperations;

    // Constructors
    public TestSequence(int numberOfThreads, int readPercent, int updatePercent, int iteratePercent) {
        this.totalOperations = 0;
        this.numberOfThreads = numberOfThreads;
        this.readPercent = readPercent;
        this.updatePercent = updatePercent;
        this.iteratePercent = iteratePercent;

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
        Thread[] threads = new Thread[testers.length];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(testers[i]);
        }
        return threads;
    }

    private void warmUpTest() {
        Collection<Integer> values = new ArrayList<>(WARM_UP_ITERATIONS);
        for (int i = 0; i < WARM_UP_ITERATIONS; i++) {
            values.add(Utilities.randomInt(WARM_UP_ITERATIONS));
        }
        collection.fillCollection(values);

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



            collection.resetCollection();
            System.gc();
        }
    }

}
