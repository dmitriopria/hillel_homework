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

    boolean run(int distance) {
        while (distance <= maxRunDistance) {                    // if or while here doesn't matter?
            this.maxRunDistance = maxRunDistance - distance;
            System.out.print(getName() + " runs ");             // is it ok? first part of line
            return true;
        }
        System.out.print(getName() + " can't run ");
        return false;                                           // I don't like boolean chain logic
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
