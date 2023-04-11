package homework16;

import java.io.File;
import java.util.*;

public class FileNavigator {
    private Map<String, List<File>> fileMap = new HashMap();

    public void add(String path) {
        File file = new File(path);
        if (file.exists()) {
            if (fileMap.containsKey(path)) {
                fileMap.get(path).add(file);
            } else {
                List<File> fileList = new ArrayList<>();
                fileList.add(file);
                fileMap.put(path, fileList);
            }
        } else {
            System.out.println("NO FILE");
        }
    }

    public List<File> find(String path) {
        return fileMap.get(path);
    }

    public List<File> filterBySize(long maxFileSize) {
        List<File> result = new ArrayList<>();
        for (List<File> fileList : fileMap.values()) {
            for (File fileData : fileList) {
                if (fileData.length() <= maxFileSize) {
                    result.add(fileData);
                }
            }
        }
        return result;
    }

    public void remove(String path) {
        fileMap.remove(path);
    }

    public List<File> sortBySize() {
        List<File> allFiles = new ArrayList<>();
        for (List<File> files : fileMap.values()) {
            allFiles.addAll(files);
        }
        Collections.sort(allFiles, Comparator.comparingLong(File::length));
        return allFiles;
    }
}
