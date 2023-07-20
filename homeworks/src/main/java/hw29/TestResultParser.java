package hw29;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestResultParser {
    private TestResult testResult;

    public TestResultParser(TestResult testResult) {
        this.testResult = testResult;
    }

    public void saveTestSummaryToFile(TestResult testResult) {
        Path filePath = Paths.get("test_summary.txt");
        try {
            Files.writeString(filePath, "Test run summary:\n");
            Files.writeString(filePath, "Total tests: " + testResult.getTotalTests() + "\n", StandardOpenOption.APPEND);
            Files.writeString(filePath, "Successful tests: " + testResult.getSuccessfulTests() + "\n", StandardOpenOption.APPEND);
            Files.writeString(filePath, "Failed tests: " + testResult.getFailedTests() + "\n", StandardOpenOption.APPEND);
            Files.writeString(filePath, "Execution time: " + testResult.getExecutionTime() + "\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
