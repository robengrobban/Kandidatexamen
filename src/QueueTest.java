import java.util.concurrent.LinkedTransferQueue;

public class QueueTest extends TestSequence {

    // Constructors
    public QueueTest(int numberOfThreads, int readPercent, int updatePercent, int iteratePercent) {
        super(numberOfThreads, readPercent, updatePercent, iteratePercent);
    }

    // Methods
    @Override
    protected CollectionToTest createCollectionToTest() {
        return new CollectionToTest() {
            private LinkedTransferQueue<Integer> queue = new LinkedTransferQueue<>();

            @Override
            public void readOperation() {
                queue.peek();
            }

            @Override
            public void updateOperation() {
                queue.poll();
            }

            @Override
            public void iterateOperation() {
                queue.iterator();
            }

            @Override
            public void resetCollection() {
                queue = new LinkedTransferQueue<>();
            }
        };
    }

}
