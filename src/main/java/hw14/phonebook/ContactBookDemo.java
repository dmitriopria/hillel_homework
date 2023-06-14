package hw14.phonebook;

public class ContactBookDemo {
    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();
        contactBook.add(new Record("Dima", 123456789));
        contactBook.add(new Record("Dima", 123));
        contactBook.add(new Record("Julia", 456));
        System.out.println(contactBook.find("Dima").toString());
        System.out.println(contactBook.find("Kiril"));
        System.out.println(contactBook.findAll("Dima").toString());
    }
}
