package homework16;

public class FileData {
    private final String name;
    private final long size;
    private final String path;

    public FileData(String name, long size, String path) {
        this.name = name;
        this.size = size;
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    public String getPath() {
        return path;
    }
}
