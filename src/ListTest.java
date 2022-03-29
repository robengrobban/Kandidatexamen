public class ListTest extends TestSequence {

    // Constructors
    public ListTest(int numberOfThreads, int readPercent, int updatePercent, int iteratePercent) {
        super(numberOfThreads, readPercent, updatePercent, iteratePercent);
    }

    // Methods
    @Override
    protected CollectionToTest createCollectionToTest() {
        return null;
    }

}
