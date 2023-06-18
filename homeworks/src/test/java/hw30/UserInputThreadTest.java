package hw30;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UserInputThreadTest {
    @Mock
    private Socket socket;

    private UserInputThread userInputThread;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        userInputThread = new UserInputThread(socket);
    }

    @Test
    void whenReadUserInputThenReceiveCorrectUserMessage() throws IOException {
        String userInput = "Test Message\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        when(socket.getOutputStream()).thenReturn(outputStream);
        when(socket.isClosed()).thenReturn(false);
        when(socket.isOutputShutdown()).thenReturn(false);

        System.setIn(inputStream);
        userInputThread.run();
        System.setIn(System.in);

        String expectedOutput = "Test Message\n";
        assertEquals(expectedOutput, outputStream.toString());
    }
}
