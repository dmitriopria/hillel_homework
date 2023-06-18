package hw11and12;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManagerIO {
    private static final Logger LOGGER = Logger.getLogger(FileManagerIO.class.getName());
    private String currentDirectory;

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            currentDirectory = System.getProperty("user.dir");
            while (true) {
                LOGGER.log(Level.INFO, "{0}>", currentDirectory);
                String command = reader.readLine();
                String[] tokens = command.split("\\s+");
                switch (tokens[0]) {
                    case "cd" -> changeDirectory(tokens);
                    case "cp" -> copyFile(tokens);
                    case "ls" -> listDirectory();
                    case "pwd" -> printWorkingDirectory();
                    case "exit" -> System.exit(0);
                    default -> LOGGER.log(Level.WARNING, "Unknown command: {0}", command);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Input command can't be read ", e);
        }
    }

    private void changeDirectory(String[] tokens) {
        if (tokens.length < 2) {
            LOGGER.log(Level.INFO, "Usage: cd <directory>");
            return;
        }
        String path = tokens[1];

        if (path.equals("..")) {
            File file = new File(currentDirectory);
            currentDirectory = file.getParent();
        } else if (path.startsWith("/")) {
            currentDirectory = path;
        } else {
            currentDirectory += "/" + path;
        }
        File file = new File(currentDirectory);
        if (!file.exists() || !file.isDirectory()) {
            LOGGER.log(Level.INFO, "Directory does not exist: {0}", currentDirectory);
            currentDirectory = System.getProperty("user.dir");
        }
    }

    private void copyFile(String[] tokens) {
        if (tokens.length < 3) {
            LOGGER.log(Level.INFO, "Usage: cp <source_file> <destination_file>");
            return;
        }
        String sourcePath = tokens[1];
        String destinationPath = tokens[2];
        File sourceFile = new File(sourcePath);
        File destinationFile = new File(destinationPath);

        if (!sourceFile.exists() || !sourceFile.isFile()) {
            LOGGER.log(Level.WARNING, "Source file does not exist: {0}", sourcePath);
            return;
        }
        if (destinationFile.exists()) {
            LOGGER.log(Level.WARNING, "Destination file already exists: {0}", destinationPath);
            return;
        }
        try (FileInputStream inputStream = new FileInputStream(sourceFile);
             FileOutputStream outputStream = new FileOutputStream(destinationFile)) {
            byte[] buffer = new byte[1024];
            int length;

            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            LOGGER.log(Level.INFO, "File copied successfully: {0}", destinationPath);
        } catch (IOException e) {
            throw new RuntimeException("Error copying file", e);
        }
    }

    private void listDirectory() {
        File directory = new File(currentDirectory);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                LOGGER.log(Level.INFO, file.getName());
            }
        }
    }

    private void printWorkingDirectory() {
        LOGGER.log(Level.INFO, currentDirectory);
    }
}

