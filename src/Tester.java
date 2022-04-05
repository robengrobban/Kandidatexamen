public class Tester implements Runnable {

    // Instance variables
    private int operations;
    private final int readPercent;
    private final int updatePercent;
    private final int iteratePercent;
    private final Operation[] sequence;
    private final CollectionToTest collection;

    // Constructors
    public Tester(int readPercent, int updatePercent, int iteratePercent, CollectionToTest collection) {
        this.operations = 0;
        this.readPercent = readPercent;
        this.updatePercent = updatePercent;
        this.iteratePercent = iteratePercent;
        this.sequence = createOperationSequence();
        this.collection = collection;
    }

    // Methods
    private Operation[] createOperationSequence() {
        Operation[] sequence = new Operation[readPercent+updatePercent+iteratePercent];
        for (int i = 0; i < readPercent; i++) {
            sequence[i] = Operation.READ;
        }
        for (int i = 0; i < updatePercent; i++) {
            sequence[readPercent+i] = Operation.UPDATE;
        }
        for (int i = 0; i < iteratePercent; i++) {
            sequence[readPercent+updatePercent+i] = Operation.ITERATE;
        }
        Utilities.shuffleArray(sequence);
        return sequence;
    }

    public int getOperations() {
        return this.operations;
    }

    @Override
    public void run() {
        int currentOperation = 0;
        do {
            switch (sequence[currentOperation % sequence.length]) {
                case READ:
                    collection.readOperation();
                    operations++;
                    break;
                case UPDATE:
                    collection.updateOperation();
                    operations++;
                    break;
                case ITERATE:
                    collection.iterateOperation();
                    operations++;
                    break;
                default:
                    throw new IllegalArgumentException();
            }
            currentOperation++;
        } while(!Thread.currentThread().isInterrupted());
    }
}
