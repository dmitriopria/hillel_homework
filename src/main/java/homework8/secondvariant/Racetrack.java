package homework8.secondvariant;

import java.util.Objects;

public class Racetrack extends Obstacle {
    public Racetrack(String name, int distance) {
        super(name, distance);
    }

    @Override
    public boolean overcome(Participant participant) {
        Objects.requireNonNull(participant);
        return participant.getMaxRunDistance() >= getDifficulty();
    }

}
