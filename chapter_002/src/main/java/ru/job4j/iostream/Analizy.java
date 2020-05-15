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
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            in.lines()
                    .map(s -> s.split(" "))
                    .forEach(this::filterData);
            recordResult(target);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    private void recordResult(String target) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (String info : rsl) {
                out.write(info);
            }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }

    private void filterData(String[] arr) {
            String status = arr[0];
            String time = arr[1];
            if ((status.equals("400") || status.equals("500")) && !isRecorded) {
                rsl.add(time + ";");
                isRecorded = true;
            } else if ((status.equals("200") || status.equals("300")) && isRecorded) {
                rsl.add(time + System.lineSeparator());
                isRecorded = false;
            }
    }
}
