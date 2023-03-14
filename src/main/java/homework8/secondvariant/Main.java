package homework8.secondvariant;

public class Main {
    public static void main(String[] args) {
        Participant[] participants = new Participant[]{
                new Human("John", 1000, 2),
                new Cat("Tom", 500, 3),
                new Robot("R2D2", 1200, 3)
        };
        Obstacle[] obstacles;
        obstacles = new Obstacle[]{
                new Racetrack("first racetrack", 200),
                new Wall("first wall", 2),
                new Racetrack("second racetrack", 300),
                new Wall("second wall", 1),
                new Racetrack("third racetrack", 500),
                new Wall("third wall", 3)
        };

        for (Participant participant : participants) {
            for (Obstacle obstacle : obstacles) {
                if (!obstacle.overcome(participant)) {
                    System.out.println(participant.getName() + " can't pass " +
                            obstacle.getObstacleName() + " which is " +
                            obstacle.getDifficulty() + " and out.");
                    break;
                } else {
                    System.out.println(participant.getName() + " passed " +
                            obstacle.getObstacleName() + " which is " + obstacle.getDifficulty());
                }
            }
            System.out.println();
        }
    }

}

