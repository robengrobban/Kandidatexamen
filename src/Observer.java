import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

public class Observer {

    private final String filename;
    private final List<TestResult> testResults = new ArrayList<>();

    public Observer(String filename) {
        this.filename = filename + ".csv";
    }

    public void saveResult(TestResult result) {
        testResults.add(result);
    }

    public void writeToFile() {
        try {
            PrintWriter out = new PrintWriter(new FileWriter(new File(filename)));
            for (TestResult result : testResults) {
                out.println(result);
            }
            out.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
