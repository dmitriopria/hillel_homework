package homework8;

import java.util.Objects;

public class Wall extends Obstacle {
    public Wall(String name, int height) {
        super(name, height);
    }

    @Override
    public boolean overcome(Participant participant) {
        Objects.requireNonNull(participant);
        if (participant.jump(getDifficulty())) {
            System.out.println(getObstacleName() + " with height " + getDifficulty());
            return true;
        } else {
            System.out.println(getObstacleName() + " with height " + getDifficulty() + " and lose.");
            return false;
        }
    }
}
