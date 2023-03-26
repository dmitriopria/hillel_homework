package homework8.secondvariant;

public abstract class Obstacle {

    private final String obstacleName;
    private final int difficulty;

    protected Obstacle(String obstacleName, int difficulty) {
        this.obstacleName = obstacleName;
        this.difficulty = difficulty;
    }

    public abstract boolean overcome(Participant participant);

    public String getObstacleName() {
        return obstacleName;
    }

    public int getDifficulty() {
        return difficulty;
    }

}
