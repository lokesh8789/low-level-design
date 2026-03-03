package com.lld;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        WinningStrategy rowWinningStrategy = new RowWinningStrategy();
        WinningStrategy columnWinningStrategy = new ColumnWinningStrategy();
        WinningStrategy diagonalWinningStrategy = new DiagonalWinningStrategy();
        WinningStrategy antiDiagonalWinningStrategy = new AntiDiagonalWinningStrategy();

        List<WinningStrategy> winningStrategyList = new ArrayList<>();
        winningStrategyList.add(rowWinningStrategy);
        winningStrategyList.add(columnWinningStrategy);
        winningStrategyList.add(diagonalWinningStrategy);
        winningStrategyList.add(antiDiagonalWinningStrategy);

        Scanner sc = new Scanner(System.in);
        System.out.println("Lets Start Tic-tac-toe Game");
        System.out.print("Choose board size: ");
        int n = Integer.parseInt(sc.nextLine().trim());

        Board board = new Board(n, winningStrategyList);

        Player playerX = new HumanPlayer("X", PlayerType.X);
        Player playerO = new HumanPlayer("O", PlayerType.O);

        Game game = new Game(board, playerX, playerO, sc);
        game.startGame();

        System.out.println("Game Finished");
    }
}