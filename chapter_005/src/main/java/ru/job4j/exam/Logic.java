package ru.job4j.exam;

public interface Logic {
    void makeMove(Point point, Mark mark);

    Mark getMark(Point point);

    boolean isMovePossible(Point point);

    Mark checkWinner();

    int getBoardSize();

    void newGame();

    boolean isAvailableCells();
}
