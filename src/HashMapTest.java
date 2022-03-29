public class HashMapTest extends TestSequence {

    // Constructors
    public HashMapTest(int numberOfThreads, int readPercent, int updatePercent, int iteratePercent) {
        super(numberOfThreads, readPercent, updatePercent, iteratePercent);
    }

    // Methods
    @Override
    protected CollectionToTest createCollectionToTest() {
        return null;
    }

}
