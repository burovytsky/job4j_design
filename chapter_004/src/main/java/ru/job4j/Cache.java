package ru.job4j;

import java.io.*;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class Cache {
    private final Map<String, SoftReference<String>> cache = new HashMap<>();

    public void getData(String name) {
        if (cache.get(name) == null) {
            SoftReference<String> stringSoftReference = new SoftReference<>(readData(name));
            cache.put(name, stringSoftReference);
        }
        System.out.println(cache.get(name).get());
    }

    private String readData(String fileName) {
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(
                new FileReader("C:\\Users\\cns\\IdeaProjects\\job4j_design\\chapter_004\\data\\" + fileName))) {
            in.lines().forEach(rsl::append);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl.toString();
    }

    public static void main(String[] args) {
        Cache cache = new Cache();
        cache.getData("names.txt");
        cache.getData("addresses.txt");
    }
}
