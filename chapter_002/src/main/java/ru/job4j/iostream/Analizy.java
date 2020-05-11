package ru.job4j.iostream;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
public class Analizy {

    public static void unavailable(String source, String target) {
        boolean isRecorded = false;
        Map<String, String> logs = new TreeMap<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            in.lines()
                    .map(s -> s.split(" "))
                    .forEach(strings -> logs.put(strings[1], strings[0]));

            for (Map.Entry<String, String> entry : logs.entrySet()) {
                if ((entry.getValue().equals("400") || entry.getValue().equals("500")) && !isRecorded) {
                    out.write(entry.getKey() + ";");
                    isRecorded = true;
                } else if ((entry.getValue().equals("200") || entry.getValue().equals("300")) && isRecorded) {
                    out.write(entry.getKey() + System.lineSeparator());
                    isRecorded = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
