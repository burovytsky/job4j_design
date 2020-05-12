package ru.job4j.iostream;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Analizy {
    private List<String> rsl = new ArrayList<>();
    private boolean isRecorded = false;

    public void unavailable(String source, String target) {
        Map<String, String> logs = new TreeMap<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            in.lines()
                    .map(s -> s.split(" "))
                    .forEach(strings -> logs.put(strings[1], strings[0]));

            for (Map.Entry<String, String> entry : logs.entrySet()) {
                if ((entry.getValue().equals("400") || entry.getValue().equals("500")) && !isRecorded) {
                    rsl.add(entry.getKey() + ";");
                    isRecorded = true;
                } else if ((entry.getValue().equals("200") || entry.getValue().equals("300")) && isRecorded) {
                    rsl.add(entry.getKey());
                    isRecorded = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        recordResult(rsl, target);
    }

    private void recordResult(List<String> list, String target) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (String str : list) {
                out.write(str);
                if (!str.endsWith(";")) {
                    out.write(System.lineSeparator());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
