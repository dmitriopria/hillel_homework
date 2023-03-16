package homework8.secondvariant;

import java.util.Objects;

public class Wall extends Obstacle {
    public Wall(String name, int height) {
        super(name, height);
    }

    @Override
    public boolean overcome(Participant participant) {
        Objects.requireNonNull(participant);
        return participant.getMaxJumpHeight() >= getDifficulty();
    }

}
