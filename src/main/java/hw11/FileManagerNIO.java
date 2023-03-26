package hw11;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.*;

public class FileManagerNIO {
    private Path currentDirectory = Paths.get("").toAbsolutePath();

    public void run() throws IOException {
        ReadableByteChannel channel = Channels.newChannel(System.in);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        StringBuilder stringBuilder = new StringBuilder();
        while (channel.read(byteBuffer) < 0) {
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                stringBuilder.append((char) byteBuffer.get());
            }
            byteBuffer.clear();
            channel.close();
        }
        while (true) {
            System.out.print(currentDirectory + "> ");
            String command = String.valueOf(stringBuilder);
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "cd" -> changeDirectory(tokens);
                case "cp" -> copyFile(tokens);
                case "ls" -> listFiles();
                case "pwd" -> printWorkingDirectory();
                case "exit" -> System.exit(0);
                default -> System.out.println("Unknown command");
            }
        }
    }

    private void changeDirectory(String[] tokens) {
        if (tokens.length < 2) {
            System.out.println("Usage: cd <directory>");
            return;
        }
        String path = tokens[1];

        if (path.equals("..")) {
            currentDirectory = currentDirectory.getParent();
        } else if (path.startsWith("/")) {
            currentDirectory = Paths.get(path);
        } else {
            currentDirectory = currentDirectory.resolve(path);
        }
        if (!Files.exists(currentDirectory) || !Files.isDirectory(currentDirectory)) {
            System.out.println("Directory does not exist: " + currentDirectory);
            currentDirectory = currentDirectory.getParent();
        }
    }

    private void copyFile(String[] tokens) {
        if (tokens.length < 3) {
            System.out.println("Usage: cp <source_file> <destination_file>");
            return;
        }
        Path source = Paths.get(tokens[1]);
        Path destination = Paths.get(tokens[2]);

        if (!Files.exists(source)) {
            System.out.println("Source file does not exist: " + source);
            return;
        }
        try {
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully");
        } catch (Exception e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
    }

    private void listFiles() {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(currentDirectory)) {
            for (Path file : stream) {
                System.out.println(file.getFileName());
            }
        } catch (Exception e) {
            System.out.println("Error listing files: " + e.getMessage());
        }
    }

    private void printWorkingDirectory() {
        System.out.println(currentDirectory);
    }
}