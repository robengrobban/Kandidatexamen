import java.util.*;

public class WarmUpSequence {

    // Class Variables
    private static final int TEST_ITERATIONS = 20000;

    // Instance Variables
    private final CollectionToTest collection;
    private final List<Integer> startCollection;

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

    private List<Integer> createStartingCollection() {
        List<Integer> startingCollection = new ArrayList<>(TEST_ITERATIONS);
        for (int i = 0; i < TEST_ITERATIONS; i++) {
            startingCollection.add(i);
        }
        return startingCollection;
    }

    private void warmUpTest() {
        System.out.print("WARM UP START ("+collection+") ... ");
        collection.fillCollection(startCollection);

        for (int i = 0; i < TEST_ITERATIONS; i++) {
            Object dummyOne = collection.readOperation();
            Object dummyTwo = collection.updateOperation();
            Object dummyThree = collection.iterateOperation();
            if ( dummyOne.hashCode() == 0 || dummyTwo.hashCode() == 0 || dummyThree.hashCode() == 0 ) {
                System.out.print("!");
            }
        }

        collection.resetCollection();
        System.gc();
        System.out.println("DONE");
    }


}
