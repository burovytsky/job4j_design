package ru.job4j.iostream;


import java.util.HashMap;
import java.util.Map;

public class ArgZip {
    private final String[] args;
    private Map<String, String> arguments = new HashMap<>();

    public ArgZip(String[] args) {
        this.args = args;
        parseArguments();
    }


    public boolean valid() {
        return args.length == 6 && (args[0].equals("-d") && args[2].equals("-e") && args[4].equals("-o"));
    }

    private void parseArguments() {
        if (!valid()) {
            throw new IllegalArgumentException("invalid startup options");
        }
        for (int i = 0; i < args.length - 1; i++) {
            arguments.put(args[i], args[++i]);
        }
    }

    public String directory() {
        return arguments.get("-d");
    }

    public String exclude() {
        return arguments.get("-e");
    }

    public String output() {
        return arguments.get("-o");
    }
}
