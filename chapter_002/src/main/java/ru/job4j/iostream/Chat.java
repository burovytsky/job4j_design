package ru.job4j.iostream;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class Chat {
    public List<String> getList(String source) {
        List<String> rsl = new ArrayList<>();
        try (FileInputStream in = new FileInputStream(source)) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                char readChar = (char) read;
                text.append(readChar);
            }
            rsl = Arrays.asList(text.toString().split(" "));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
            for (String str : log) {
                out.write(str + System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void chatRun() {
        List<String> list = getList("./chapter_002/data/text.txt");
        List<String> log = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String userMessage = "";
        while (!userMessage.equals("закончить")) {
            userMessage = input.nextLine();
            log.add("user: " + userMessage);
            if (!userMessage.equals("стоп")) {
                String pcMessage = list.get((int) (Math.random() * list.size()));
                log.add("pc: " + pcMessage);
                System.out.println(pcMessage);
            } else {
                while (!userMessage.equals("продолжить")) {
                    userMessage = input.nextLine();
                    log.add("user: " + userMessage);
                }
            }
        }
        save(log, "./chapter_002/data/log.txt");
    }

    public static void main(String[] args) {
        new Chat().chatRun();
    }
}
