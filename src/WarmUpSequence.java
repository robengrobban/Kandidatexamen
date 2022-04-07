import java.util.ArrayList;
import java.util.List;

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
        collection.fillCollection(startCollection);

        for (int i = 0; i < TEST_ITERATIONS; i++) {
            collection.readOperation();
            collection.updateOperation();
            collection.iterateOperation();
        }

        collection.resetCollection();
        System.gc();
        System.out.println("\t --- WARM UP SEQUENCE DONE ---");
    }


}
