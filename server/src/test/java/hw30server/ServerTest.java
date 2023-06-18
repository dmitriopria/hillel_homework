package hw30server;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

class ServerTest {
    private Server server;

    @Mock
    private ServerSocket serverSocket;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        server = new Server();
    }

    @Test
    void testServerStart() throws IOException {
        List<ClientHandler> activeConnections = new ArrayList<>();
        Socket socket = Mockito.mock(Socket.class);
        Mockito.when(serverSocket.accept()).thenReturn(socket);
        server.start();
        assertEquals(1, activeConnections.size());
        verify(socket).close();
    }
}