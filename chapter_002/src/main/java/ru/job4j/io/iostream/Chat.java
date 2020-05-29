package ru.job4j.io.iostream;

import java.io.*;
import java.util.*;

public class Chat {
    private static final String EXIT = "закончить";
    private static final String STOP = "стоп";
    private static final String RESUME = "продолжить";

    public List<String> getList(String source) {
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            while (in.ready()) {
                rsl.addAll(Arrays.asList(in.readLine().split(" ")));
            }
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

    public void chatRun(String source, String save) {
        List<String> list = getList(source);
        List<String> log = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String userMessage = "";
        while (!userMessage.equals(EXIT)) {
            userMessage = input.nextLine();
            log.add("user: " + userMessage);
            if (!userMessage.equals(STOP)) {
                String pcMessage = list.get((int) (Math.random() * list.size()));
                log.add("pc: " + pcMessage);
                System.out.println(pcMessage);
            } else {
                while (!userMessage.equals(RESUME)) {
                    userMessage = input.nextLine();
                    log.add("user: " + userMessage);
                }
            }
        }
        save(log, save);
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Arguments not found");
        }
        new Chat().chatRun(args[0], args[1]);
    }
}
