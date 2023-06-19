package hw28;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.*;

import static org.mockito.Mockito.verify;

class FileLoggerTest {

    @Mock
    private FileLogger logger;

    @Captor
    private ArgumentCaptor<String> argumentCaptor;

    @BeforeEach
    void setup() {
        logger = new FileLogger();
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void whenPerformDebugMessageThenCaptureThisMessage() {
        String message = "Debug message";
        logger.debug(message);
        Mockito.verify(logger).debug(argumentCaptor.capture());
        String capturedArgument = argumentCaptor.getValue();
        Assertions.assertEquals(message, capturedArgument);
    }

    @Test
    void whenPerformInfoMessageThenCaptureThisMessage() {
        String message = "Info message";
        logger.info(message);
        Mockito.verify(logger).info(argumentCaptor.capture());
        String capturedArgument = argumentCaptor.getValue();
        Assertions.assertEquals(message, capturedArgument);
    }
}
