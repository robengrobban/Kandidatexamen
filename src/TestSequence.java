public abstract class TestSequence {

    // Instance variables
    private final int numberOfThreads;
    private final int readPercent;
    private final int updatePercent;
    private final int iteratePercent;
    private final Tester[] testers;
    private final Thread[] threads;

    private CollectionToTest collectionToTest;

    private int totalOperations;

    // Constructors
    public TestSequence(int numberOfThreads, int readPercent, int updatePercent, int iteratePercent) {
        this.totalOperations = 0;
        this.numberOfThreads = numberOfThreads;
        this.readPercent = readPercent;
        this.updatePercent = updatePercent;
        this.iteratePercent = iteratePercent;
        this.testers = createTester(numberOfThreads, readPercent, updatePercent, iteratePercent);
        this.threads = createThreads(this.testers);
    }

    // Methods
    private Tester[] createTester(int numberOfThreads, int readPercent, int updatePercent, int iteratePercent) {
        Tester[] testers = new Tester[numberOfThreads];
        for (int i = 0; i < testers.length; i++) {
            testers[i] = new Tester(readPercent, updatePercent, iteratePercent);
        }
        return testers;
    }
    private Thread[] createThreads(Tester[] testers) {
        Thread[] threads = new Thread[testers.length];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(testers[i]);
        }
        return threads;
    }

}
