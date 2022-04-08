public class OperationsDistribution {

    private OperationsDistribution(int read, int update, int iterate ) {
        READ = read;
        UPDATE = update;
        ITERATE = iterate;
    }
    public final int READ;
    public final int UPDATE;
    public final int ITERATE;

    public static OperationsDistribution HigRead() { return new OperationsDistribution(70, 15, 15);}
    public static OperationsDistribution HighMod() { return new OperationsDistribution(15, 70, 15);}
    public static OperationsDistribution HigIter() { return new OperationsDistribution(15, 15, 70);}
    public static OperationsDistribution Even() { return new OperationsDistribution(34, 33, 33);}
}
