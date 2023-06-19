package hw28;

import hw10.FailedToWriteLogException;
import hw10.FileLoggerConfiguration;
import hw10.FileLoggerConfigurationLoader;
import hw10.LoggingLevel;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class FileLogger {
    private static final DateTimeFormatter FILE_DATE_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private final FileLoggerConfiguration configuration;

    public FileLogger() {
        this.configuration = new FileLoggerConfigurationLoader()
                .loadConfiguration("configuration.properties");
    }

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
            writeToFile(createNextFile(), createFormattedMessage(level, message));
        }
        writeToFile(createNextFile(), createFormattedMessage(level, message));
    }

    private void writeToFile(File file, String message) {
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

    private File createNextFile() {
        String fileName = configuration.getFile().getName();
        String fileExtension = "";
        int dotIndex = fileName.lastIndexOf(".");
        if (dotIndex != -1) {
            fileExtension = fileName.substring(dotIndex);
            fileName = fileName.substring(0, dotIndex);
        }
        String newFileName = fileName + "_" + LocalDateTime.now().format(FILE_DATE_FORMATTER) + fileExtension;
        return new File(configuration.getFile().getParent(), newFileName);
    }

    private boolean isDebugEnabled() {
        return configuration.getLoggingLevel() == LoggingLevel.DEBUG;
    }

    private boolean isInfoEnabled() {
        return configuration.getLoggingLevel() == LoggingLevel.INFO
                || configuration.getLoggingLevel() == LoggingLevel.DEBUG;
    }

    private boolean isMaxFileSizeExceeded() {
        return configuration.getFile().length() > configuration.getMaxFileSize();
    }
}
