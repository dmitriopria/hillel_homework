package hw29;

import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.util.Date;

public class TestResultMapper {
    private TestExecutionSummary summary;

    public TestResultMapper(TestExecutionSummary summary) {
        this.summary = summary;
    }

    public TestResult mapResult(TestExecutionSummary summary) {
        return new TestResult(
                summary.getTestsFoundCount(),
                summary.getTestsSucceededCount(),
                summary.getTestsFailedCount(),
                new Date()
        );
    }
}
