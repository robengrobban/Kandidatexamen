public class OperationsDistribution {

    private final int readPercent;
    private final int updatePercent;
    private final int iteratePercent;

    public OperationsDistribution(int readPercent, int updatePercent, int iteratePercent ) {
        this.readPercent = readPercent;
        this.updatePercent = updatePercent;
        this.iteratePercent = iteratePercent;
    }

    public static OperationsDistribution highRead() {return new OperationsDistribution(75, 10, 15);}
    public static OperationsDistribution highUpdate() {return new OperationsDistribution(18, 65, 17);}
    public static OperationsDistribution highIterate() {return new OperationsDistribution(15, 10, 75);}
    public static OperationsDistribution even() {return new OperationsDistribution(38, 25, 37);}

    public int getReadPercent() {
        return this.readPercent;
    }

    public int getUpdatePercent() {
        return this.updatePercent;
    }

    public int getIteratePercent() {
        return this.iteratePercent;
    }

}
