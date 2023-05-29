package hw11and12;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
//        FileManagerIO fileManagerIO = new FileManagerIO();
//        fileManagerIO.run();

        FileManagerNIO fileManagerNIO = new FileManagerNIO();
        fileManagerNIO.run();
    }
}
