package homework9;

public class ArrayDataException extends Exception {
    public ArrayDataException(String message, NumberFormatException e) {
        super(message);
    }
}
