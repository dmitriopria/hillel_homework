package homework8.secondvariant;

public abstract class Obstacle {

    private String obstacleName;
    private int difficulty;

    protected Obstacle(String obstacleName, int difficulty) {           // protected?
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
