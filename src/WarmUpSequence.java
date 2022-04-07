public class WarmUpSequence {

    // Class Variables
    private static final int TEST_ITERATIONS = 20000;

    // Instance Variables
    private final CollectionToTest collection;
    private final Integer[] startCollection;

    // Constructor
    private WarmUpSequence(CollectionToTest collection) {
        this.collection = collection;
        this.startCollection = createStartingCollection();
        warmUpTest();
    }

    // Methods
    public static void queue() {
        new WarmUpSequence(new QueueToTest());
    }
    public static void list() {
        new WarmUpSequence(new ListToTest());
    }
    public static void hashMap() {
        new WarmUpSequence(new HashMapToTest());
    }
    public static void treeMap() {
        new WarmUpSequence(new TreeMapToTest());
    }

    private Integer[] createStartingCollection() {
        Integer[] startingCollection = new Integer[TEST_ITERATIONS];
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            startingCollection[i] = i;
        }
        return startingCollection;
    }

    private void warmUpTest() {
        System.out.print("\tWARM UP START ... ");
        collection.fillCollection(startCollection);

        for (int i = 0; i < TEST_ITERATIONS; i++) {
            collection.readOperation();
            collection.updateOperation();
            collection.iterateOperation();
        }

        collection.resetCollection();
        System.gc();
        System.out.println("DONE");
    }


}
