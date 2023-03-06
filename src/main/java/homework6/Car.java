package homework6;

public class Car {

    /* Створити клас Car з публічним методом start. Метод start викликає у собі методи:
    - startElectricity()
    - startCommand()
    - startFuelSystem()
    Перелічені методи, є внутрішньою (прихованою) частиною комплексного методу start.
    Вони по суті відображають внутрішню поведінку класу Car і не повинні
    використовуватися за межами даного класу. */

    public void start() {
        startElectricity();
        startCommand();
        startFuelSystem();
        System.out.println("Engine started");
    }

    private void startElectricity() {
        System.out.println("Start electricity");
    }
    private void startCommand() {
        System.out.println("Start command");

    }
    private void startFuelSystem() {
        System.out.println("Start fuel system");
    }

}
