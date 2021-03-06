package ru.job4j.io.iostream;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("C:\\ideaProjects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        for (File subFile : file.listFiles()) {
            System.out.println("File name: " + subFile.getName() + ", size: " + subFile.length());
        }
    }
}
