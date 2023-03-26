package hw10;

public class FileMaxSizeReachedException extends RuntimeException {
    private final String filePath;
    private final long maxFileSize;
    private final long currentFileSize;

    public FileMaxSizeReachedException(String message, String filePath, long maxFileSize, long currentFileSize) {
        super(message);
        this.filePath = filePath;
        this.maxFileSize = maxFileSize;
        this.currentFileSize = currentFileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public long getMaxFileSize() {
        return maxFileSize;
    }

    public long getCurrentFileSize() {
        return currentFileSize;
    }
}
