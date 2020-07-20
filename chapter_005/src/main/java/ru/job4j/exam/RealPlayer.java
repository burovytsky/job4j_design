package ru.job4j.exam;

import java.util.Scanner;

public class RealPlayer implements Player {
    private final Logic logic;
    private final Scanner scanner;
    private final String name;
    private final Mark mark;

    public RealPlayer(Logic logic, String name, Mark mark) {
        this.logic = logic;
        this.name = name;
        this.mark = mark;
        scanner = new Scanner(System.in);
    }

    @Override
    public void move() {
        Point point;
        System.out.println("Enter the X coordinate");
        int pointX = scanner.nextInt();
        System.out.println("Enter the Y coordinate");
        int pointy = scanner.nextInt();

        boolean move = false;
        while (!move) {
            point = new Point(pointX, pointy);
            if (!logic.isMovePossible(point)) {
                logic.makeMove(point, mark);
                System.out.println("Enter the X coordinate");
                pointX = scanner.nextInt();
                System.out.println("Enter the Y coordinate");
                pointy = scanner.nextInt();
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
