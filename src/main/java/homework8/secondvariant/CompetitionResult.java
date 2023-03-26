package homework8.secondvariant;

import java.util.List;

public class CompetitionResult {
    private List<String> successResult;
    private List<String> failureResult;

    public CompetitionResult(List<String> successResult, List<String> failureResult) {
        this.successResult = successResult;
        this.failureResult = failureResult;
    }

    public List<String> getSuccessResult() {
        return successResult;
    }

    public List<String> getFailureResult() {
        return failureResult;
    }

    public String getCompetitionResult() {
        return getSuccessResult().toString() + "\n" + getFailureResult().toString();
    }
}


