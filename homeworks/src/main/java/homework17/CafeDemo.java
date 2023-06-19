package homework17;

public class CafeDemo {
    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.add("Dima1");
        coffeeOrderBoard.add("Dima2");
        System.out.println(coffeeOrderBoard.draw());
        coffeeOrderBoard.add("Julia");
        coffeeOrderBoard.deliver(1);
        coffeeOrderBoard.deliver();
        System.out.println(coffeeOrderBoard.draw());
        coffeeOrderBoard.deliver();
        coffeeOrderBoard.deliver();
    }
}
