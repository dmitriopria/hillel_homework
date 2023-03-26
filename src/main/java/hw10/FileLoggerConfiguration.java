package hw10;

import java.io.File;
import java.io.IOException;

public class FileLoggerConfiguration {
    private File file;
    private static LoggingLevel loggingLevel;
    private long maxFileSize;
    private String messageFormat;

    public static void loadTextToFile(String message) throws IOException {
        FileLoggerConfiguration configuration = new FileLoggerConfigurationLoader()
                .load("C:/hillel/hillel_homework/src/main/java/hw10/configuration.txt");
        FileLogger logger = new FileLogger(configuration);
        if (getLoggingLevel() == LoggingLevel.DEBUG) {
            logger.debug(message);
        } else {
            logger.info(message);
        }
    }

    public File getFile() {
        return file;
    }

    public static LoggingLevel getLoggingLevel() {
        return loggingLevel;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public String getMessageFormat() {
        return messageFormat;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setLoggingLevel(LoggingLevel loggingLevel) {
        FileLoggerConfiguration.loggingLevel = loggingLevel;
    }

    public void setMaxFileSize(long maxFileSize) {
        this.maxFileSize = maxFileSize;
    }

    public void setMessageFormat(String messageFormat) {
        this.messageFormat = messageFormat;
    }
}
