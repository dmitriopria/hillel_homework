package homework10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileLoggerConfigurationLoader {
    public FileLoggerConfiguration load(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        FileLoggerConfiguration configuration = new FileLoggerConfiguration();
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("-");
            String key = parts[0].trim();
            String value = parts[1].trim();
            switch (key) {
                case "FILE" -> configuration.setFile(new File(value));
                case "LEVEL" -> configuration.setLoggingLevel(LoggingLevel.valueOf(value));
                case "SIZE" -> configuration.setMaxFileSize(Long.parseLong(value));
                case "FORMAT" -> configuration.setMessageFormat(value);
                default -> System.err.println("Unknown configuration key: " + key);
            }
        }
        reader.close();
        return configuration;
    }
}
