package homework7.abstractdecitiontest;

public class Cat extends Animal {

    private static int catCount = 0;
    private int maxRunDistance = 200;

    public Cat(String name) {
        super(name);
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 0) {
            System.out.println("Enter valid number");
        } else if (distance <= maxRunDistance) {
            System.out.println(name + " ran " + distance + " m.");
        } else {
            System.out.println(name + " couldn't run " + distance + " m.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name + " can't swim.");
    }

    public static int getCatCount() {
        return catCount;
    }

}
