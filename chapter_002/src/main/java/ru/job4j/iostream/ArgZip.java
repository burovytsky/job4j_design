package ru.job4j.iostream;

import java.util.Arrays;

public class ArgZip {
    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid(String argument) {
        return Arrays.asList(args).contains(argument);
    }

    private String getArgument(String argument) {
        String rsl = null;
        if (!valid(argument)) {
            throw new IllegalArgumentException("invalid startup options");
        }
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals(argument)) {
                rsl = args[i + 1];
            }
        }
        return rsl;
    }

    public String directory() {
        return getArgument("-d");
    }

    public String exclude() {
        return getArgument("-e");
    }

    public String output() {
        return getArgument("-o");
    }
}
