package hw30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;

public class UserInputThread implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(UserInputThread.class.getName());
    private Socket clientSocket;

    public UserInputThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public void run() {
        readUserInput();
    }

    private void readUserInput() {
        try (BufferedReader userInputReader = new BufferedReader(new InputStreamReader(System.in));
             OutputStream outputStream = clientSocket.getOutputStream()) {
            String input;
            while ((input = userInputReader.readLine()) != null) {
                outputStream.write((input + "\n").getBytes());
                if (input.equalsIgnoreCase("-exit")) {
                    break;
                } else if (input.startsWith("-file")) {
                    String filePath = input.substring(6).trim();
                    LOGGER.info("File uploaded: " + filePath);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error in user input thread: " + e.getMessage(), e);
        }
    }
}
