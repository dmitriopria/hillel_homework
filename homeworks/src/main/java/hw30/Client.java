package hw30;

import hw30server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Logger;

public class Client {
    private static final Logger LOGGER = Logger.getLogger(Client.class.getName());

    public void connect() {
        try (Socket clientSocket = new Socket(Server.HOST, Server.PORT);
             BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            LOGGER.info("Connected to the server.");
            Thread userInputThread = new Thread(new UserInputThread(clientSocket));
            userInputThread.start();
            String message;
            while ((message = reader.readLine()) != null) {
                LOGGER.info(message);
            }
        } catch (SocketException e) {
            throw new RuntimeException("Disconnected from server: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException("Error in client: " + e.getMessage(), e);
        }
    }
}
