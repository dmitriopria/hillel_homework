package hw30;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;

import static org.mockito.Mockito.*;

class ClientTest {
    @Mock
    private Socket socket;
    @Mock
    private BufferedReader reader;

    private Client client;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        client = new Client();
    }

    @Test
    void testConnectAndReceiveMessages() throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream("Test Message\n".getBytes());
        when(socket.getInputStream()).thenReturn(inputStream);
        when(socket.isClosed()).thenReturn(false);
        when(socket.isInputShutdown()).thenReturn(false);
        when(socket.isOutputShutdown()).thenReturn(false);
        when(socket.isInputShutdown()).thenReturn(false);
        when(socket.isOutputShutdown()).thenReturn(false);
        when(socket.getKeepAlive()).thenReturn(true);
        when(reader.readLine()).thenReturn("Test Message", null);
        client.connect();
        verify(socket).getInputStream();
        verify(socket, atLeastOnce()).isClosed();
        verify(socket, atLeastOnce()).isInputShutdown();
        verify(socket, atLeastOnce()).isOutputShutdown();
        verify(reader, times(2)).readLine();
    }

    @Test
    void testConnectAndCatchSocketException() throws IOException {
        when(socket.getInputStream()).thenThrow(new SocketException());
        client.connect();
        verify(socket).getInputStream();
        verify(socket, atLeastOnce()).isClosed();
        verify(socket, atLeastOnce()).isInputShutdown();
        verify(socket, atLeastOnce()).isOutputShutdown();
    }
}
