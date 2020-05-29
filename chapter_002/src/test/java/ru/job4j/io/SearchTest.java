package ru.job4j.io;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.io.iostream.Search;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class SearchTest {

    @Test@Ignore
    public void searchTest() throws IOException {
        Path start = Paths.get("C:\\ideaProjects\\job4j_design\\chapter_002");
        List<Path> searchRsl = Search.search(start, "Search");
        List<String> expected = List.of("Search.java",
                "SearchFiles.java",
                "SearchTest.java",
                "Search.class",
                "SearchFiles.class",
                "SearchTest.class");
        List<String> rslToString = searchRsl.stream().map(Path::toString).collect(Collectors.toList());
        assertEquals(expected, rslToString);
    }
}