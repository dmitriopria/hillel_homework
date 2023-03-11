package homework7.abstractdecitiontest;

public abstract class Animal {

    private static int animalCount;
    protected String name;

    public Animal(String name) {
        this.name = name;
        animalCount++;
    }

    public abstract void run(int distance);

    public abstract void swim(int distance);

    public static int getAnimalCount() {
        return animalCount;
    }

}
