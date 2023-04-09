package hw10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class FileLoggerConfigurationLoader {
    public FileLoggerConfiguration loadConfiguration(String filePath) {
        Objects.requireNonNull(filePath);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            File file = null;
            long maxFileSize = 0;
            LoggingLevel loggingLevel = null;
            String messageFormat = "";
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("=");
                String key = parts[0].trim();
                String value = parts[1].trim();
                switch (key) {
                    case "file" -> file = new File(value);
                    case "level" -> loggingLevel = LoggingLevel.valueOf(value);
                    case "size" -> maxFileSize = Long.parseLong(value);
                    case "format" -> messageFormat = value;
                }
            }
            return new FileLoggerConfiguration(file, loggingLevel, maxFileSize, messageFormat);
        } catch (IOException e) {
            throw new LoadConfigFileException("Error of loading configuration file: " + e.getMessage());
        }
    }
}