package homework7.abstractdecitiontest;

public class Main {
    public static void main(String[] args) {

        Cat murzik = new Cat("Murzik");
        Dog bobik = new Dog("Bobik");
        Cat barsik = new Cat("Barsik");

        murzik.run(100);
        murzik.swim(20);
        bobik.run(550);
        bobik.swim(5);
        barsik.run(300);
        barsik.swim(0);

        System.out.println(Animal.getAnimalCount() + " animal created");
        System.out.println(Cat.getCatCount() + " cat created");
        System.out.println(Dog.getDogCount() + " dog created");

    }

}
