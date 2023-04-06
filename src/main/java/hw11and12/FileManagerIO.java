package hw11and12;

import java.io.*;

public class FileManagerIO {
    private String currentDirectory;
    public void run() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        currentDirectory = System.getProperty("user.dir");
        while (true) {
            System.out.print(currentDirectory + ">");
            String command = reader.readLine();
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "cd" -> changeDirectory(tokens);
                case "cp" -> copyFile(tokens);
                case "ls" -> listDirectory();
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
            File file = new File(currentDirectory);
            currentDirectory = file.getParent();
        } else if (path.startsWith("/")) {
            currentDirectory = path;
        } else {
            currentDirectory += "/" + path;
        }
        File file = new File(currentDirectory);
        if (!file.exists() || !file.isDirectory()) {
            System.out.println("Directory does not exist: " + currentDirectory);
            currentDirectory = System.getProperty("user.dir");
        }
    }

    private void copyFile(String[] tokens) throws IOException {
        if (tokens.length < 3) {
            System.out.println("Usage: cp <source_file> <destination_file>");
            return;
        }
        String sourcePath = tokens[1];
        String destinationPath = tokens[2];
        File sourceFile = new File(sourcePath);
        File destinationFile = new File(destinationPath);

        if (!sourceFile.exists() || !sourceFile.isFile()) {
            System.out.println("Source file does not exist: " + sourcePath);
            return;
        }
        if (destinationFile.exists()) {
            System.out.println("Destination file already exists: " + destinationPath);
            return;
        }
        FileInputStream inputStream = new FileInputStream(sourceFile);
        FileOutputStream outputStream = new FileOutputStream(destinationFile);
        byte[] buffer = new byte[1024];
        int length;

        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.close();
        System.out.println("File copied successfully: " + destinationPath);
    }

    private void listDirectory() {
        File directory = new File(currentDirectory);
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }
    }

    private void printWorkingDirectory() {
        System.out.println(currentDirectory);
    }

}

