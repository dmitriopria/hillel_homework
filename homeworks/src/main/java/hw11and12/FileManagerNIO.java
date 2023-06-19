package hw11and12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManagerNIO {
    private static final Logger LOGGER = Logger.getLogger(FileManagerIO.class.getName());
    private Path currentDirectory = Paths.get("").toAbsolutePath();

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            currentDirectory = Path.of(System.getProperty("user.dir"));
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
        switch (path) {
            case ".." -> currentDirectory = currentDirectory.getParent();
            case "/" -> currentDirectory = Paths.get(path);
            default -> currentDirectory = currentDirectory.resolve(path);
        }
    }

    private void copyFile(String[] tokens) {
        if (tokens.length < 3) {
            LOGGER.log(Level.INFO, "Usage: cp <source_file> <destination_file>");
            return;
        }
        Path source = Paths.get(tokens[1]);
        Path destination = Paths.get(tokens[2]);

        if (!Files.exists(source)) {
            LOGGER.log(Level.WARNING, "Source file does not exist: {0}", source);
            return;
        }
        if (Files.exists(destination)) {
            LOGGER.log(Level.WARNING, "Destination file already exists: {0}", destination);
            return;
        }
        try {
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            LOGGER.log(Level.INFO, "File copied successfully: {0}", destination);
        } catch (IOException e) {
            throw new RuntimeException("Error copying file", e);
        }
    }

    private void listDirectory() {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(currentDirectory)) {
            for (Path file : stream) {
                LOGGER.log(Level.INFO, file.getFileName().toString());
            }
        } catch (IOException e) {
            throw new RuntimeException("Error listing files ", e);
        }
    }

    private void printWorkingDirectory() {
        LOGGER.log(Level.INFO, currentDirectory.toString());
    }
}