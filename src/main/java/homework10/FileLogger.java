package homework10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class FileLogger {
    private final FileLoggerConfiguration configuration;
    private final DateTimeFormatter fileDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public FileLogger(FileLoggerConfiguration configuration) {
        this.configuration = configuration;
    }

    public void debug(String message) {
        Objects.requireNonNull(message);
        log(LoggingLevel.DEBUG, message);
    }

    public void info(String message) {
        Objects.requireNonNull(message);
        log(LoggingLevel.INFO, message);
    }

    private void log(LoggingLevel level, String message) {
        if (level.compareTo(FileLoggerConfiguration.getLoggingLevel()) < 0) {
            return;
        }
        if (configuration.getFile().length() >= configuration.getMaxFileSize()) {
            createNextFile();
            createFormattedMessage(level, message);
        }
        createFormattedMessage(level, message);
    }

    private void writeToFile(String message) {
        File file = configuration.getFile();
        long fileSize = file.length();
        long maxSize = configuration.getMaxFileSize();
        if (fileSize >= maxSize) {
            throw new FileMaxSizeReachedException("File size exceeded maximum limit.",
                    file.getAbsolutePath(), maxSize, fileSize);
        }
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(message);
            writer.flush();
        } catch (IOException e) {
            System.err.printf("Failed to write log message to file %s: %s%n",
                    file.getAbsolutePath(), e.getMessage());
        }
    }

    private void createFormattedMessage(LoggingLevel level, String message) {
        String formattedMessage = String.format(configuration.getMessageFormat(),
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                level, message);
        writeToFile(formattedMessage);
    }

    private File createNextFile() {
        String fileName = configuration.getFile().getName();
        String fileExtension = "";
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex != -1) {
            fileExtension = fileName.substring(dotIndex);
            fileName = fileName.substring(0, dotIndex);
        }
        String newFileName = fileName + "_" + LocalDateTime.now().format(fileDateFormatter) + fileExtension;
        return new File(configuration.getFile().getParent(), newFileName);
    }

}