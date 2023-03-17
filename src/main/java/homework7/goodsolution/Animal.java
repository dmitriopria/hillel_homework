package homework7.goodsolution;

public class Animal {

    private static int animalCount;
    private String name;
    private int maxRunDistance;
    private int maxSwimDistance;

    public Animal(String name, int maxRunDistance, int maxSwimDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        animalCount++;
    }

    public void run(int distance) {
        if (distance <= 0) {
            System.out.println("Enter valid number");
        } else if (distance <= maxRunDistance) {
            System.out.println(name + " ran " + distance + " m.");
        } else {
            System.out.println(name + " couldn't run " + distance + " m.");
        }
    }

    public void swim(int distance) {
        if (distance <= 0) {
            System.out.println("Enter valid number");
        } else if (distance <= maxSwimDistance) {
            System.out.println(name + " swam " + distance + " m.");
        } else {
            System.out.println(name + " couldn't swim " + distance + " m.");
        }
    }

    public static int getAnimalCount() {
        return animalCount;
    }
    public String getName() {
        return name;
    }

}
