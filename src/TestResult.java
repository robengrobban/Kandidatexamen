public class TestResult {

    private final String name;
    private final String version;
    private final int threads;
    private final int elements;
    private final int readPercent;
    private final int updatePercent;
    private final int iteratePercent;
    private final int throughput;

    public TestResult(String name, String version, int threads, int elements, int readPercent, int updatePercent, int iteratePercent, int throughput) {
        this.name = name;
        this.version = version;
        this.threads = threads;
        this.elements = elements;
        this.readPercent = readPercent;
        this.updatePercent = updatePercent;
        this.iteratePercent = iteratePercent;
        this.throughput = throughput;
    }

    @Override
    public String toString() {
        return name + "," + version + "," + threads + "," + elements + "," + readPercent + "-" + updatePercent + "-" + iteratePercent + "," + throughput;
    }

}
