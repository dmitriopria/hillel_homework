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
//        Objects.requireNonNull(filePath);
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            File file = null;
//            long maxFileSize = 0;
//            LoggingLevel loggingLevel = null;
//            String messageFormat = "";
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split("=");
//                String key = parts[0].trim();
//                String value = parts[1].trim();
//                switch (key) {
//                    case "file" -> file = new File(value);
//                    case "level" -> loggingLevel = LoggingLevel.valueOf(value);
//                    case "size" -> maxFileSize = Long.parseLong(value);
//                    case "format" -> messageFormat = value;
//                }
//            }
//            return new FileLoggerConfiguration(file, loggingLevel, maxFileSize, messageFormat);
//        } catch (IOException e) {
//            throw new LoadConfigFileException("Error of loading configuration file: " + e.getMessage());
//        }
//    }