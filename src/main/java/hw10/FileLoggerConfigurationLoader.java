package hw10;

import java.io.*;
import java.util.Objects;
import java.util.Properties;

public class FileLoggerConfigurationLoader {
    public FileLoggerConfiguration loadConfiguration(String fileName) {
        Objects.requireNonNull(fileName);
        Properties properties = new Properties();
        try (InputStream inputStream = FileLoggerConfigurationLoader
                .class.getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream != null) {
                properties.load(inputStream);
            } else {
                throw new LoadConfigFileException("Configuration file is not found!");
            }
            File file = new File(properties.getProperty("file"));
            LoggingLevel loggingLevel = LoggingLevel.valueOf(properties.getProperty("level"));
            long maxFileSize = Long.parseLong(properties.getProperty("size"));
            String messageFormat = properties.getProperty("format");
            return new FileLoggerConfiguration(file, loggingLevel, maxFileSize, messageFormat);
        } catch (IOException e) {
            throw new LoadConfigFileException("Error of reading configuration file!");
        }
    }
}
