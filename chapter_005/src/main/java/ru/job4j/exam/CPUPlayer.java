package ru.job4j.exam;

import java.util.Random;

public class CPUPlayer implements Player {
    private final Logic logic;
    private final String name;
    private final Mark mark;

    public CPUPlayer(Logic logic, String name, Mark mark) {
        this.logic = logic;
        this.name = name;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    @Override
    public void move() {
        Random random = new Random();
        Point point ;
        int pointX = random.nextInt(3);
        int pointy = random.nextInt(3);

        boolean move = false;
        while (!move) {
            point = new Point(pointX, pointy);
            if (!logic.isMovePossible(point)) {
                logic.makeMove(point, mark);
                pointX = random.nextInt(3);
                pointy = random.nextInt(3);
            } else {
                logic.makeMove(point, mark);
                move = true;
            }

        }
    }

    @Override
    public String toString() {
        return name;
    }
}

