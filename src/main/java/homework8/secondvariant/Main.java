package homework8.secondvariant;

public class Main {
    public static void main(String[] args) {
        Participant[] participants = new Participant[]{
                new Human("John", 1000, 2),
                new Cat("Tom", 500, 3),
                new Robot("R2D2", 1200, 3)
        };
        Obstacle[] obstacles = {
                new Racetrack("first racetrack", 200),
                new Wall("first wall", 2),
                new Racetrack("second racetrack", 300),
                new Wall("second wall", 1),
                new Racetrack("third racetrack", 500),
                new Wall("third wall", 3)
        };
        Competition competition = new Competition();
        CompetitionResult result = competition.start(participants, obstacles);
        System.out.println(result.getCompetitionResult());
    }
}

