package hw14.phonebook;

public class Record {
    private String name;
    private int number;

    public Record(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Record{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
