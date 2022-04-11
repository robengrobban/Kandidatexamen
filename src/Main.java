public class Main {

    private static final int[] NUMBER_OF_THREADS = { 1, 3, 6, 12, 24, 48 };
    private static final int[] NUMBER_OF_ELEMENTS = { 32768, 185363, 1048576 };
    private static final OperationsDistribution[] Operations = {
            OperationsDistribution.HigRead(),
            OperationsDistribution.HighMod(),
            OperationsDistribution.HigIter(),
            OperationsDistribution.Even()};

    // Entry point to tests
    public static void main(String[] args) {
        String version = System.getProperty("java.version");
        /* ======================================== SECTION QUEUE ======================================== */
        Observer observer = new Observer("Queue-"+version);
        WarmUpSequence.queue();
        for (int num_elem : NUMBER_OF_ELEMENTS) {
            for (OperationsDistribution op : Operations) {
                for (int threads : NUMBER_OF_THREADS) {
                    TestSequence.queue(threads, num_elem, op.READ, op.UPDATE, op.ITERATE, observer);
                }
            }
        }
        observer.writeToFile();

        /* ========================================= SECTION LIST ======================================== */
        observer = new Observer("List-"+version);
        WarmUpSequence.list();
        for (int num_elem : NUMBER_OF_ELEMENTS) {
            for (OperationsDistribution op : Operations) {
                for (int threads : NUMBER_OF_THREADS) {
                    TestSequence.list(threads, num_elem, op.READ, op.UPDATE, op.ITERATE, observer);
                }
            }
        }
        observer.writeToFile();

        /* ======================================= SECTION HASHMAP ======================================= */
        observer = new Observer("HashMap-"+version);
        WarmUpSequence.hashMap();
        for (int num_elem : NUMBER_OF_ELEMENTS) {
            for (OperationsDistribution op : Operations) {
                for (int threads : NUMBER_OF_THREADS) {
                    TestSequence.hashMap(threads, num_elem, op.READ, op.UPDATE, op.ITERATE, observer);
                }
            }
        }
        observer.writeToFile();

        /* ======================================= SECTION TREEMAP ======================================= */
        observer = new Observer("TreeMap-"+version);
        WarmUpSequence.treeMap();
        for (int num_elem : NUMBER_OF_ELEMENTS) {
            for (OperationsDistribution op : Operations) {
                for (int threads : NUMBER_OF_THREADS) {
                    TestSequence.treeMap(threads, num_elem, op.READ, op.UPDATE, op.ITERATE, observer);
                }
            }
        }
        observer.writeToFile();
    }

}
