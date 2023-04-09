package hw10;

public class Main {
    public static void main(String[] args) {
        String message = "test1";
        FileLogger logger = new FileLogger();
        logger.debug(message);
        logger.info(message);
    }
}


