public abstract class TestSequence {

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
        this.testers = createTester(numberOfThreads, readPercent, updatePercent, iteratePercent, collection);
        this.threads = createThreads(this.testers);
    }

    // Methods
    abstract protected CollectionToTest createCollectionToTest();

    private Tester[] createTester(int numberOfThreads, int readPercent, int updatePercent, int iteratePercent, CollectionToTest collection) {
        Tester[] testers = new Tester[numberOfThreads];
        for (int i = 0; i < testers.length; i++) {
            testers[i] = new Tester(readPercent, updatePercent, iteratePercent, collection);
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
