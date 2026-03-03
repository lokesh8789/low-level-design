package com.lld;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Game {
    private final Board board;
    private final Player playerX;
    private final Player playerO;
    private final Scanner sc;

    public Game(Board board, Player playerX, Player playerO, Scanner sc) {
        this.board = board;
        this.playerX = playerX;
        this.playerO = playerO;
        this.sc = sc;
    }

    public void startGame() {
        System.out.print("Choose which player will first start (X or O): ");
        String playerType = sc.nextLine();

        switch (playerType.trim()) {
            case "X" -> {
                board.addPlayer(playerX);
                board.addPlayer(playerO);
            }
            case "O" -> {
                board.addPlayer(playerO);
                board.addPlayer(playerX);
            }
            default -> {
                System.out.println("Invalid Choice");
                return;
            }
        }

        System.out.println();
        ArrayDeque<Player> playerQueue = board.getPlayerQueue();
        boolean isWon = false;
        boolean isDraw = false;
        while (!isWon && !isDraw) {
            Player player = playerQueue.remove();
            boolean isWrongPosition = true;
            while (isWrongPosition) {
                System.out.print("Choose Position For Player" + player.type + ": ");
                String positionLine = sc.nextLine().trim();
                String[] positions = positionLine.split(",");
                if (positions.length != 2) {
                    System.out.println("Wrong Position Selected, Choose Again");
                    System.out.println();
                    continue;
                }

                try {
                    int x = Integer.parseInt(positions[0].trim());
                    int y = Integer.parseInt(positions[1].trim());
                    MoveResult moveResult = board.choosePositionAndCheckWon(x, y, player);
                    board.printBoard();
                    switch (moveResult) {
                        case INVALID -> {
                            System.out.println("Wrong Position Selected, Choose Again");
                            System.out.println();
                            continue;
                        }
                        case VALID -> {}
                        case WON -> {
                            isWon = true;
                            System.out.println("Game Finished, Player: " + player.name + " has won");
                        }
                        case DRAW -> {
                            isDraw = true;
                            System.out.println("Match Draw, No Result");
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Wrong Position Selected, Choose Again");
                    System.out.println();
                    continue;
                }
                isWrongPosition = false;
            }

            if (!isWon && !isDraw) {
                playerQueue.add(player);
            }
        }
    }
}
