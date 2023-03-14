package homework8.secondvariant;

import java.util.Objects;

public class Wall extends Obstacle {
    public Wall(String name, int height) {
        super(name, height);
    }

    @Override
    public boolean overcome(Participant participant) {
        Objects.requireNonNull(participant);
        if (participant.getMaxJumpHeight() >= getDifficulty()) {            // simplify??
            // System.out.println(participant.getName() + " passed " + getObstacleName() + " with height " + getDifficulty());
            return true;
        } else {
            // System.out.println(participant.getName() + " can't pass " + getObstacleName() + " with height " + getDifficulty() + " and out.");
            return false;
        }
    }

}
