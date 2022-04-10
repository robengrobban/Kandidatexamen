public class Main {

    private static final int[] NUMBER_OF_THREADS = { 1, 3, 6, 9, 12, 15, 18, 21, 24, 27, 30, 33, 36, 39, 42 };
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
        for (int num_elem : NUMBER_OF_ELEMENTS) {
            for (OperationsDistribution op : Operations) {
                for (int threads : NUMBER_OF_THREADS) {
                    TestSequence.queue(threads, num_elem, op.READ, op.UPDATE, op.ITERATE, observer);
                }
            }
        }
        observer.writeToFile();

        /* ========================================= SECTION LIST ======================================== */
        observer = new Observer("List-17");
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
        observer = new Observer("HashMap-17");
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
        observer = new Observer("TreeMap-17");
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

    private static void testFor8() {
        /* ======================================== SECTION QUEUE ======================================== */
        Observer observer = new Observer("Queue-8");
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
        observer = new Observer("List-8");
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
        observer = new Observer("HashMap-8");
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
        observer = new Observer("TreeMap-8");
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
