package homework8.secondvariant;

import java.util.Objects;

public class Racetrack extends Obstacle {
    public Racetrack(String name, int distance) {
        super(name, distance);
    }

    @Override
    public boolean overcome(Participant participant) {
        Objects.requireNonNull(participant);
        if (participant.getMaxRunDistance() >= getDifficulty()) {
            participant.setMaxRunDistance(participant.getMaxRunDistance() - getDifficulty());
            // System.out.println(participant.getName() + " passed " + getObstacleName() + " with length " + getDifficulty());
            return true;
        } else {
            // System.out.println(participant.getName() + " can't pass " + getObstacleName() + " with length " + getDifficulty() + " and out.");
            return false;
        }
    }

}
