package homework8;

public abstract class Obstacle {
    private String obstacleName;
    private int difficulty;

    public Obstacle(String obstacleName, int difficulty) {
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
