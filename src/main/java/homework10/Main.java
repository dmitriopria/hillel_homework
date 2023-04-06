package homework10;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String message = "test3";
        FileLoggerConfiguration.loadTextToFile(message);
    }
}

