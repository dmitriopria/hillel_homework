package homework8;

import java.util.Objects;

public class Racetrack extends Obstacle {
    public Racetrack(String name, int distance) {
        super(name, distance);
    }

    @Override
    public boolean overcome(Participant participant) {
        Objects.requireNonNull(participant);
        if (participant.run(getDifficulty())) {
            System.out.println(getObstacleName() + " with distance " + getDifficulty());
            return true;
        } else {
            System.out.println(getObstacleName() + " with distance " + getDifficulty() + " and lose.");
            return false;
        }
    }
}
