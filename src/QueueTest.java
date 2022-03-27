import java.util.concurrent.LinkedTransferQueue;

public class QueueTest extends TestSequence {

    // Instance variables
    private final CollectionToTest queueToTest = new CollectionToTest() {
        private final LinkedTransferQueue<Integer> queue = new LinkedTransferQueue<>();

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
    };


    // Constructors
    public QueueTest(int numberOfThreads, int readPercent, int updatePercent, int iteratePercent) {
        super(numberOfThreads, readPercent, updatePercent, iteratePercent);
    }

    // Methods

}
