package ru.job4j.iostream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Search {
    public static List<Path> search(Path root, String ext) throws IOException {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().contains(ext));
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
