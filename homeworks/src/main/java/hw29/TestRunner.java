package hw29;

import org.junit.platform.launcher.listeners.TestExecutionSummary;

public class TestRunner {
    public static void main(String[] args) {
        ProjectTestRunner testRunner = new ProjectTestRunner();
        TestExecutionSummary summary = testRunner.runTests();

        TestResultMapper testResultMapper = new TestResultMapper(summary);
        TestResult testResult = testResultMapper.mapResult(summary);

        TestResultParser testResultParser = new TestResultParser(testResult);
        testResultParser.saveTestSummaryToFile(testResult);
    }
}
