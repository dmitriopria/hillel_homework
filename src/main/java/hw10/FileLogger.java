package hw10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class FileLogger {
    private static final DateTimeFormatter fileDateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final FileLoggerConfiguration configuration =
            new FileLoggerConfigurationLoader()
                    .loadConfiguration("C:/hillel/hillel_homework/src/main/java/hw10/configuration.txt");

    public void debug(String message) {
        Objects.requireNonNull(message);
        if (isDebugEnabled()) {
            log(LoggingLevel.DEBUG, message);
        }
    }

    public void info(String message) {
        Objects.requireNonNull(message);
        if (isInfoEnabled()) {
            log(LoggingLevel.INFO, message);
        }
    }

    private void log(LoggingLevel level, String message) {
        if (isMaxFileSizeExceeded()) {
            createNextFile();
            writeToFile(createFormattedMessage(level, message));
        }
        writeToFile(createFormattedMessage(level, message));
    }

    private void writeToFile(String message) {
        File file = configuration.getFile();
        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(message);
            writer.flush();
        } catch (IOException e) {
            String errorMessage = String.format("Failed to write log message to file %s: %s%n",
                    file.getAbsolutePath(), e.getMessage());
            throw new FailedToWriteLogException(errorMessage);
        }
    }

    private String createFormattedMessage(LoggingLevel level, String message) {
        return String.format(configuration.getMessageFormat(),
                LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
                level, message);
    }

    private void createNextFile() {
        String fileName = configuration.getFile().getName();
        String fileExtension = "";
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex != -1) {
            fileExtension = fileName.substring(dotIndex);
            fileName = fileName.substring(0, dotIndex);
        }
        String newFileName = fileName + "_" + LocalDateTime.now().format(fileDateFormatter) + fileExtension;
        new File(configuration.getFile().getParent(), newFileName);
    }

    private boolean isDebugEnabled() {
        return configuration.getLoggingLevel() == LoggingLevel.DEBUG;
    }

    private boolean isInfoEnabled() {
        return configuration.getLoggingLevel() == LoggingLevel.INFO;
    }

    private boolean isMaxFileSizeExceeded() {
        return configuration.getFile().length() > configuration.getMaxFileSize();
    }
}