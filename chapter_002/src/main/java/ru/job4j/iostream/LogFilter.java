package ru.job4j.iostream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> logs = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            in.lines().filter(LogFilter::isPenultimate404).forEach(logs::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return logs;
    }

    private static boolean isPenultimate404(String string) {
        String[] array = string.split(" ");
        return array[array.length - 2].equals("404");
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        log.forEach(System.out::println);
    }
}
