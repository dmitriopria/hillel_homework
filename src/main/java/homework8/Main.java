package homework8;

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
                    break;
                }
            }
            System.out.println();
        }
    }
}

