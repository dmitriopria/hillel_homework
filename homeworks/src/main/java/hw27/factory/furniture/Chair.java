package hw27.factory.furniture;

public class Chair implements Furniture {
    @Override
    public String assemble() {
        return "Chair created";
    }
}
