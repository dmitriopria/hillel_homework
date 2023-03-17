package homework7.abstractdecitiontest;

public class Dog extends Animal {

    private static int dogCount = 0;
    private int maxRunDistance = 500;
    private int maxSwimDistance = 10;

    public Dog(String name) {
        super(name);
        dogCount++;
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
        if (distance <= 0) {
            System.out.println("Enter valid number");
        } else if (distance <= maxSwimDistance) {
            System.out.println(name + " swam " + distance + " m.");
        } else {
            System.out.println(name + " couldn't swim " + distance + " m.");
        }
    }

    public static int getDogCount() {
        return dogCount;
    }

}
