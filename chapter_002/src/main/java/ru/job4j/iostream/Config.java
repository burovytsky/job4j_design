package ru.job4j.iostream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader in = new BufferedReader(new FileReader(path))) {

            in.lines().filter(Config::stringsFilter)
                    .map(s -> s.split("="))
                    .forEach(strings -> values.put(strings[0], strings[1]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        return values.get(key);
    }

    private static boolean stringsFilter(String string) {
        boolean rsl = false;
        if (!string.isEmpty()) {
            String first = String.valueOf(string.charAt(0));
            rsl = string.contains("=") && !first.equals("#");
        }
        return rsl;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }
}
