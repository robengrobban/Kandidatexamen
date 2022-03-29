public class TreeMapTest extends TestSequence {

    // Constructors
    public TreeMapTest(int numberOfThreads, int readPercent, int updatePercent, int iteratePercent) {
        super(numberOfThreads, readPercent, updatePercent, iteratePercent);
    }

    // Methods
    @Override
    protected CollectionToTest createCollectionToTest() {
        return null;
    }

}
