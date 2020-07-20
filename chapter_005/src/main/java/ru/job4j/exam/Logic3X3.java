package ru.job4j.exam;

import java.util.function.Predicate;

public class Logic3X3 implements Logic {
    private final int size;
    private Mark[][] gameBoard;
    private Mark winner;
    private int moveNum = 0;

    public Logic3X3(int size) {
        this.size = size;
        newGame();
    }

    @Override
    public void makeMove(Point point, Mark mark) {
        if (isMovePossible(point)) {
            gameBoard[point.getX()][point.getY()] = mark;
            moveNum++;
        }
    }

    @Override
    public Mark getMark(Point point) {
        return gameBoard[point.getX()][point.getY()];
    }

    @Override
    public boolean isMovePossible(Point point) {
        if ((point.getX() >= gameBoard.length) || (point.getY() >= gameBoard.length)) {
            return false;
        } else if (gameBoard[point.getX()][point.getY()] != null) {
            return false;
        }
        return true;
    }

    @Override
    public Mark checkWinner() {
        if (isWinnerO()) {
            winner = Mark.O;
        } else if (isWinnerX()) {
            winner = Mark.X;
        }
        return winner;
    }

    @Override
    public int getBoardSize() {
        return this.size;
    }

    @Override
    public void newGame() {
        this.moveNum = 0;
        this.gameBoard = new Mark[this.size][this.size];
        this.winner = null;
    }

    @Override
    public boolean isAvailableCells() {
        return moveNum < gameBoard.length * gameBoard.length;
    }

    private boolean isWinner(Predicate<Mark> predicate) {
        for (int i = 0; i < gameBoard.length; i++) {
            if (this.fillBy(predicate, 0, i, 1, 0) ||
                    this.fillBy(predicate, i, 0, 0, 1) ||
                    this.fillBy(predicate, 0, 0, 1, 1) ||
                    this.fillBy(predicate, this.gameBoard.length - 1, 0, -1, 1)) {
                return true;
            }
        }
        return false;
    }

    private boolean fillBy(Predicate<Mark> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.gameBoard.length; index++) {
            Mark cell = this.gameBoard[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    private boolean isWinnerX() {
        return isWinner(Mark.X::equals);
    }

    private boolean isWinnerO() {
        return isWinner(Mark.O::equals);
    }

}
