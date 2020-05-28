package ru.job4j.examenation;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static List<Path> search(Path root, Predicate<Path> predicate) throws IOException {
        SearchFiles searcher = new SearchFiles(predicate);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void save(List<Path> log, String file) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
            for (Path str : log) {
                out.write(str.getFileName() + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgSearch argSearch = new ArgSearch(args); //  startup options "-d C:/ideaProjects/job4j_design/chapter_002 -n Search -r -o logrsl.txt"
        List<Path> list = Search.search(Paths.get(argSearch.directory()), argSearch.exclude());
        save(list, argSearch.output());
    }
}
