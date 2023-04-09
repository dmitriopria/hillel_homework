package hw10;

import java.io.File;

public class FileLoggerConfiguration {
    private File file;
    private LoggingLevel loggingLevel;
    private long maxFileSize;
    private String messageFormat;

    public FileLoggerConfiguration(File file, LoggingLevel loggingLevel, long maxFileSize, String messageFormat) {
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
