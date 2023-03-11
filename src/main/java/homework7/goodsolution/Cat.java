package homework7.goodsolution;

public class Cat extends Animal {

    private static int catCount = 0;

    public Cat(String name) {
        super(name, 200, 0);
        catCount++;
    }

    @Override
    public void swim(int distance) {
        System.out.println(super.getName() + " can't swim.");
    }

    public static int getCatCount() {
        return catCount;
    }

}
