package homework8.secondvariant;

import java.util.ArrayList;
import java.util.List;

public class Competition {
    public CompetitionResult start(Participant[] participants, Obstacle[] obstacles) {
        List<String> successResult = new ArrayList<>();
        List<String> failureResult = new ArrayList<>();
        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.overcome(participant)) {
                    failureResult.add(participant.getName() + " can't pass " +
                            obstacle.getObstacleName() + " which is " +
                            obstacle.getDifficulty() + " and out.");
                    break;
                } else {
                    successResult.add(participant.getName() + " passed " +
                            obstacle.getObstacleName() + " which is " + obstacle.getDifficulty());
                }
            }
        }
        return new CompetitionResult(successResult, failureResult);
    }
}
