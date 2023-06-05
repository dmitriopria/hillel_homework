package hw10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

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
        verify(logger).debug(argumentCaptor.capture());
        String capturedArgument = argumentCaptor.getValue();
        Assertions.assertEquals(message, capturedArgument);
    }

    @Test
    void whenPerformInfoMessageThenCaptureThisMessage() {
        String message = "Info message";
        logger.info(message);
        verify(logger).info(argumentCaptor.capture());
        String capturedArgument = argumentCaptor.getValue();
        Assertions.assertEquals(message, capturedArgument);
    }
}
