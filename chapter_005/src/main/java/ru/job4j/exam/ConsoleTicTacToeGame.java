package ru.job4j.exam;

public class ConsoleTicTacToeGame implements TicTacToeGame {
    private final Player player1;
    private final Player player2;
    private final Logic logic;
    private final int gameBoardSize;
    private Player nextPlayer;
    private boolean exit;

    public ConsoleTicTacToeGame(Logic logic, Player player1, Player player2) {
        this.logic = logic;
        this.gameBoardSize = logic.getBoardSize();
        this.player1 = player1;
        this.player2 = player2;
        this.nextPlayer = player1;
        this.exit = false;
    }

    @Override
    public void next() {
        System.out.println("Player " + nextPlayer.toString() + " make your move");
        this.nextPlayer.move();
        showGameBoard();
        checkWinner();
        this.nextPlayer = this.nextPlayer.equals(player1) ? player2 : player1;
    }

    private void checkWinner() {
        boolean hasWinner = false;
        if (Mark.O.equals(logic.checkWinner())) {
            System.out.println(nextPlayer.toString() + " win");
            hasWinner = true;
        } else if (Mark.X.equals(logic.checkWinner())) {
            System.out.println(nextPlayer.toString() + " win");
            hasWinner = true;
        }

        if (hasWinner) {
            System.out.println("Congratulation, " + nextPlayer.toString() + " win");
            exit = true;
        }

        if (!logic.isAvailableCells() && !hasWinner) {
            System.out.println("draw. new game started");
            logic.newGame();
        }
    }

    @Override
    public boolean exit() {
        return exit;
    }

    @Override
    public void showGameBoard() {
        for (int i = 0; i < gameBoardSize; i++) {
            for (int j = 0; j < gameBoardSize; j++) {
                Mark mark = logic.getMark(new Point(i, j));
                if (mark == null) {
                    mark = Mark.H;
                }
                System.out.print(mark);
            }
            System.out.println();
        }
    }
}
