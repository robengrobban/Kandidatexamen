public class Tester implements Runnable {

    // Instance variables
    private int operations;
    private final Operation[] sequence;

    // Constructors
    public Tester(int readPercent, int updatePercent, int iteratePercent) {
        this.operations = 0;
        this.sequence = createOperationSequence(readPercent, updatePercent, iteratePercent);
    }

    // Methods
    public int getOperations() {
        return operations;
    }

    public Operation[] getSequence() {
        return sequence;
    }

    private Operation[] createOperationSequence(int readPercent, int updatePercent, int iteratePercent) {
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

    @Override
    public void run() {
        do {

        } while(!Thread.currentThread().isInterrupted());
    }
}
