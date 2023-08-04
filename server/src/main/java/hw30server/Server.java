package hw30server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class Server {
    private static final Logger LOGGER = Logger.getLogger(Server.class.getName());
    public static final int PORT = 12345;
    public static final String HOST = "localhost";
    private List<ClientHandler> activeConnections;

    public Server() {
        activeConnections = new ArrayList<>();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT);
             ExecutorServiceWrapper executorServiceWrapper = new ExecutorServiceWrapper(Executors.newCachedThreadPool())) {
            LOGGER.info("Server started. Listening on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clientSocket, activeConnections);
                activeConnections.add(clientHandler);
                executorServiceWrapper.getExecutorService().execute(clientHandler);
                if (activeConnections.isEmpty()) {
                    LOGGER.info("No active connections. Stopping the server.");
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error in server: " + e.getMessage(), e);
        }
    }
}
