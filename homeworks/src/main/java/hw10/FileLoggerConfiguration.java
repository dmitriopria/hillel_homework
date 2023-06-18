package hw10;

import java.io.File;
import java.util.Objects;

public class FileLoggerConfiguration {
    private final File file;
    private final LoggingLevel loggingLevel;
    private final long maxFileSize;
    private final String messageFormat;

    public FileLoggerConfiguration(File file, LoggingLevel loggingLevel, long maxFileSize, String messageFormat) {
        this.file = Objects.requireNonNull(file);
        this.loggingLevel = Objects.requireNonNull(loggingLevel);
        this.messageFormat = Objects.requireNonNull(messageFormat);
        this.maxFileSize = validateMaxFileSize(maxFileSize);
    }

    private long validateMaxFileSize(long maxFileSize) {
        if (maxFileSize < 1) {
            throw new IllegalArgumentException("Maximum file size must be at least 1 byte.");
        }
        return maxFileSize;
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
