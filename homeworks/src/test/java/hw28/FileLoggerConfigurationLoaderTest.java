package hw28;

import hw10.FileLoggerConfiguration;
import hw10.LoadConfigFileException;
import hw10.LoggingLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileLoggerConfigurationLoaderTest {
    private FileLoggerConfigurationLoader loader;

    @BeforeEach
    public void setup() {
        loader = new FileLoggerConfigurationLoader();
    }

    @Test
    void whenPerformLoadConfigurationMethodThenReturnValidFileLoggerConfiguration() {
        FileLoggerConfiguration configuration = loader.loadConfiguration("configuration.properties");
        Assertions.assertNotNull(configuration);
        Assertions.assertEquals("application.log", configuration.getFile().getName());
        Assertions.assertEquals(LoggingLevel.DEBUG, configuration.getLoggingLevel());
        Assertions.assertEquals(1024L, configuration.getMaxFileSize());
        Assertions.assertEquals("[%s][%s] %s%n", configuration.getMessageFormat());
    }

    @Test
    void whenWrongPropertiesFileThenThrowException() {
        LoadConfigFileException e = Assertions.assertThrows(LoadConfigFileException.class, () -> {
            loader.loadConfiguration("nonexistent.properties");
        });
        Assertions.assertNotNull(e);
        Assertions.assertEquals("Configuration file is not found!", e.getMessage());
    }
}