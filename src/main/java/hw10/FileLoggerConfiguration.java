package hw10;

import java.io.File;
import java.util.Objects;

public class FileLoggerConfiguration {
    private final File file;
    private final LoggingLevel loggingLevel;
    private final long maxFileSize;
    private final String messageFormat;

    public FileLoggerConfiguration(File file, LoggingLevel loggingLevel, long maxFileSize, String messageFormat) {
        Objects.requireNonNull(file);
        Objects.requireNonNull(loggingLevel);
        Objects.requireNonNull(messageFormat);
        if (maxFileSize < 1) {
            throw new IllegalArgumentException("Maximum file size must be at least 1 byte.");
        }
        this.file = file;
        this.loggingLevel = loggingLevel;
        this.maxFileSize = maxFileSize;
        this.messageFormat = messageFormat;
    }

    public File getFile() {
        return file;
    }

    public LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public String getMessageFormat() {
        return messageFormat;
    }
}
