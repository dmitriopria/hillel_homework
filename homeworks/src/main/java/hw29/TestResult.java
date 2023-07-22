package hw29;

import java.util.Date;
import java.util.Objects;

public class TestResult {
    private long totalTests;
    private long successfulTests;
    private long failedTests;
    private Date executionTime;

    public TestResult() {
    }

    public TestResult(long totalTests, long successfulTests, long failedTests, Date executionTime) {
        this.totalTests = totalTests;
        this.successfulTests = successfulTests;
        this.failedTests = failedTests;
        this.executionTime = executionTime;
    }

    public long getTotalTests() {
        return totalTests;
    }

    public void setTotalTests(int totalTests) {
        this.totalTests = totalTests;
    }

    public long getSuccessfulTests() {
        return successfulTests;
    }

    public void setSuccessfulTests(int successfulTests) {
        this.successfulTests = successfulTests;
    }

    public long getFailedTests() {
        return failedTests;
    }

    public void setFailedTests(int failedTests) {
        this.failedTests = failedTests;
    }

    public Date getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Date executionTime) {
        this.executionTime = executionTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestResult that = (TestResult) o;
        return totalTests == that.totalTests && successfulTests == that.successfulTests && failedTests == that.failedTests && Objects.equals(executionTime, that.executionTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(totalTests, successfulTests, failedTests, executionTime);
    }
}
