package hw25.exceptions;

public class JdbcOperationException extends RuntimeException {
    public JdbcOperationException(String message) {
        super(message);
    }

    public JdbcOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}
