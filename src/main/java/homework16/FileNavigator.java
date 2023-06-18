package homework16;

import java.util.*;

public class FileNavigator {
    private Map<String, FileData> fileMap = new HashMap<>();

    public void add(String name, long size, String path) {
        Objects.requireNonNull(path);
        FileData file = new FileData(name, size, path);
        if (!file.getPath().isEmpty()) {
            if (fileMap.containsKey(path)) {
                throw new RuntimeException("File already exists!");
            } else {
                fileMap.put(path, file);
            }
        } else {
            throw new RuntimeException("File no found!");
        }
    }

    public FileData find(String path) {
        Objects.requireNonNull(path);
        return fileMap.get(path);
    }

    public List<FileData> filterBySize(long maxFileSize) {
        if (maxFileSize > 0) {
            List<FileData> result = new ArrayList<>();
            for (FileData fileList : fileMap.values()) {
                for (FileData fileData : fileMap.values()) {
                    if (fileData.getSize() <= maxFileSize) {
                        result.add(fileData);
                    }
                }
            }
            return result;
        } else {
            throw new RuntimeException("File size mustn't be negative!");
        }
    }

    public void remove(String path) {
        Objects.requireNonNull(path);
        fileMap.remove(path);
    }

    public List<FileData> sortBySize() {
        return fileMap.values().stream().sorted().toList();
    }
}
