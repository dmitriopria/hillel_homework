package hw30server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;

public class ClientHandler implements Runnable {
    private static final Logger LOGGER = Logger.getLogger(ClientHandler.class.getName());
    private Socket clientSocket;
    private List<ClientHandler> activeConnections;

    public ClientHandler(Socket clientSocket, List<ClientHandler> activeConnections) {
        this.clientSocket = clientSocket;
        this.activeConnections = activeConnections;
    }

    public void run() {
        processClientMessage();
    }

    private void processClientMessage() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            String clientName = "client-" + activeConnections.size();
            String connectionTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            String message = "[SERVER] " + clientName + " connected. (Time: " + connectionTime + ")";
            broadcastMessage(message);

            String input;
            while ((input = reader.readLine()) != null) {
                if (input.equalsIgnoreCase("-exit")) {
                    break;
                } else if (input.startsWith("-file")) {
                    String filePath = input.substring(6).trim();
                    LOGGER.info(clientName + " uploaded file: " + filePath);
                } else {
                    LOGGER.info(clientName + " sent a message: " + input);
                }
            }
            message = "[SERVER] " + clientName + " disconnected.";
            broadcastMessage(message);
            removeClient(this);
            clientSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error handling client request: " + e.getMessage(), e);
        }
    }

    private synchronized void broadcastMessage(String message) {
        for (ClientHandler clientHandler : activeConnections) {
            clientHandler.sendMessage(message);
        }
    }

    private synchronized void removeClient(ClientHandler clientHandler) {
        activeConnections.remove(clientHandler);
    }

    void sendMessage(String message) {
        try {
            clientSocket.getOutputStream().write((message + "\n").getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error sending message to client: " + e.getMessage(), e);
        }
    }
}
