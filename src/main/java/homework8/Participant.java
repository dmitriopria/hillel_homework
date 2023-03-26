package homework8;

public class Participant {
    private String name;
    private int maxRunDistance;
    private int maxJumpHeight;

    public Participant(String name, int maxRunDistance, int maxJumpHeight) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
    }

    boolean run(int distance) {                                         // Try to make class for boolean check
        if (distance <= maxRunDistance) {
            this.maxRunDistance = maxRunDistance - distance;            // work here with other field
            System.out.print(getName() + " runs ");
            return true;
        }
        System.out.print(getName() + " can't run ");
        return false;
    }

    boolean jump(int height) {
        if (height <= maxJumpHeight) {
            System.out.print(getName() + " jumps ");
            return true;
        } else {
            System.out.print(getName() + " can't jump ");
            return false;
        }
    }

    public String getName() {
        return name;
    }
}
