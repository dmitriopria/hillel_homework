package homework6;

public class Employee {

    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private int age;

    public Employee(String fullName, String position, String email, String phoneNumber, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

/* 2. Створити клас "Співробітник" з полями: ПІБ, посада, email, телефон, вік.
    3. Конструктор класу повинен заповнювати ці поля під час створення об'єкта.
    Забезпечити інкапсуляцію внутрішніх властивостей класу. */

}
