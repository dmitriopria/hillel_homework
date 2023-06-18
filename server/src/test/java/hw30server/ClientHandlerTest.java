package hw30server;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

class ClientHandlerTest {
    private ClientHandler clientHandler;
    private List<ClientHandler> activeConnections;

    @Mock
    private Socket clientSocket;
    @Mock
    private OutputStream outputStream;

    @BeforeEach
    public void setup() throws IOException {
        MockitoAnnotations.initMocks(this);
        activeConnections = new ArrayList<>();
        clientHandler = new ClientHandler(clientSocket, activeConnections);
        Mockito.when(clientSocket.getOutputStream()).thenReturn(outputStream);
    }

    @Test
    void whenClientProcessMessageExitThenReceiveCorrectMessageFromServer() throws IOException {
        ClientHandler mockClientHandler = Mockito.mock(ClientHandler.class);
        activeConnections.add(mockClientHandler);
        ByteArrayInputStream inputStream = new ByteArrayInputStream("-exit\n".getBytes());
        Mockito.when(clientSocket.getInputStream()).thenReturn(inputStream);
        clientHandler.run();
        String connectionTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        assertEquals(1, activeConnections.size());
        verify(mockClientHandler).sendMessage("[SERVER] client-1 connected. (Time: " + connectionTime + ")");
        verify(mockClientHandler).sendMessage("[SERVER] client-1 disconnected.");
    }
}