package ru.job4j.exam;

public class Main {
    public static void main(String[] args) {
        Logic logic = new Logic3X3(3);
        Player human = new RealPlayer(logic, "Vasia", Mark.X);
        Player cpuPlayer = new CPUPlayer(logic, "CpuPlayer", Mark.O);
        TicTacToeGame ticTacToeGame = new ConsoleTicTacToeGame(logic, human, cpuPlayer);
        while (!ticTacToeGame.exit()){
            ticTacToeGame.next();
        }
    }
}
