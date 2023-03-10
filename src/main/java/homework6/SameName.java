package homework6;

public class SameName {
    public static void main(String[] args) {

        Car car = new Car();
        car.start();

        Employee employee = new Employee("Ivanov", "Developer", "ivanov@gmail.com",
                "+380987654321", 27);
        System.out.println("Employee age is: " + employee.getAge());


    }

}
