public class Main {

    private static final int[] NUMBER_OF_THREADS = { 1, 3, 6, 12, 24, 48 };
    private static final int[] NUMBER_OF_ELEMENTS = { 32768, 1048576 };
    private static final OperationsDistribution[] Operations = {
            OperationsDistribution.HigRead(),
            OperationsDistribution.HighMod(),
            OperationsDistribution.HigIter(),
            OperationsDistribution.Even()};

    // Entry point to tests
    public static void main(String[] args) {
        int version = Runtime.version().version().get(0);
        switch (version) {
            case 17:
                testFor17();
                break;
            case 8:
                testFor8();
                break;
            default:
                System.out.println("Wrong version.... :O");
        }
    }

    private static void testFor17() {

        /* ======================================== SECTION QUEUE ======================================== */
        Observer observer = new Observer("Queue-17");
        WarmUpSequence.queue();
        for (int threads : NUMBER_OF_THREADS){
            for (int num_elem : NUMBER_OF_ELEMENTS) {
                for (OperationsDistribution op : Operations)
                    TestSequence.queue(threads, num_elem, op.READ, op.UPDATE, op.ITERATE, observer);
            }
        }
        observer.writeToFile();

        /* ========================================= SECTION LIST ======================================== */
        observer = new Observer("List-17");
        WarmUpSequence.list();
        for (int threads : NUMBER_OF_THREADS) {
            for (int num_elem : NUMBER_OF_ELEMENTS) {
                for (OperationsDistribution op : Operations)
                    TestSequence.list(threads, num_elem, op.READ, op.UPDATE, op.ITERATE, observer);
            }
        }
        observer.writeToFile();

        /* ======================================= SECTION HASHMAP ======================================= */
        observer = new Observer("HashMap-17");
        WarmUpSequence.hashMap();
        for (int threads : NUMBER_OF_THREADS) {
            for (int num_elem : NUMBER_OF_ELEMENTS) {
                for (OperationsDistribution op : Operations)
                    TestSequence.hashMap(threads, num_elem, op.READ, op.UPDATE, op.ITERATE, observer);
            }
        }
        observer.writeToFile();

        /* ======================================= SECTION TREEMAP ======================================= */
        observer = new Observer("TreeMap-17");
        WarmUpSequence.treeMap();
        for (int threads : NUMBER_OF_THREADS) {
            for (int num_elem : NUMBER_OF_ELEMENTS) {
                for (OperationsDistribution op : Operations)
                    TestSequence.treeMap(threads, num_elem, op.READ, op.UPDATE, op.ITERATE, observer);
            }
        }
        observer.writeToFile();
    }

    private static void testFor8() {

    }

}
