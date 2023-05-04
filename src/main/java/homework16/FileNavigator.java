package homework16;

import java.util.*;

public class FileNavigator {
    private Map<String, List<FileData>> fileMap = new HashMap<>();

    public void add(String name, long size, String path) {
        Objects.requireNonNull(path);
        FileData file = new FileData(name, size, path);
        if (!file.getPath().isEmpty()) {
            if (fileMap.containsKey(path)) {
                fileMap.get(path).add(file);
            } else {
                List<FileData> fileList = new ArrayList<>();
                fileList.add(file);
                fileMap.put(path, fileList);
            }
        } else {
            throw new RuntimeException("File no found!");
        }
    }

    public List<FileData> find(String path) {
        Objects.requireNonNull(path);
        return fileMap.get(path);
    }

    public List<FileData> filterBySize(long maxFileSize) {
        if (maxFileSize > 0) {
            List<FileData> result = new ArrayList<>();
            for (List<FileData> fileList : fileMap.values()) {
                for (FileData fileData : fileList) {
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
        return fileMap.values().stream()
                .flatMap(List::stream)
                .sorted(Comparator.comparingLong(FileData::getSize))
                .toList();
    }
}
