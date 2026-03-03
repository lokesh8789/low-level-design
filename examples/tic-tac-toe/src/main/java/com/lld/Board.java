package com.lld;

import java.util.ArrayDeque;
import java.util.List;

public class Board {
    private final Integer[][] board;
    private final ArrayDeque<Player> playerQueue;
    private final List<WinningStrategy> winningStrategyList;
    private int moves = 0;

    public Board(int n, List<WinningStrategy> winningStrategyList) {
        this.board = new Integer[n][n];
        this.playerQueue = new ArrayDeque<>(2);
        this.winningStrategyList = winningStrategyList;
    }

    public void addPlayer(Player player) {
        playerQueue.add(player);
    }

    public ArrayDeque<Player> getPlayerQueue() {
        return playerQueue;
    }

    public MoveResult choosePositionAndCheckWon(int x, int y, Player player) {
        if (x >= board.length || x < 0 || y >= board[0].length || y < 0 || board[x][y] != null) {
            return MoveResult.INVALID;
        }

        board[x][y] = player.type.ordinal();
        moves++;

        if (checkIfWon(x, y, player)) {
            return MoveResult.WON;
        }

        if (detectDraw()) {
            return MoveResult.DRAW;
        }

        return MoveResult.VALID;
    }

    private boolean checkIfWon(int x, int y, Player player) {
        for (WinningStrategy winningStrategy : winningStrategyList) {
            if (winningStrategy.checkWon(board, x, y, player)) {
                return true;
            }
        }
        return false;
    }

    private boolean detectDraw() {
        return moves == board.length * board[0].length;
    }

    public void printBoard() {
        int n = board.length;

        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                String cell;

                if (board[i][j] == null) {
                    cell = " ";
                } else if (board[i][j] == PlayerType.X.ordinal()) {
                    cell = "X";
                } else {
                    cell = "O";
                }

                System.out.print(" " + cell + " ");

                // vertical separator
                if (j < n - 1) {
                    System.out.print("|");
                }
            }

            System.out.println();

            // horizontal separator
            if (i < n - 1) {
                for (int k = 0; k < n; k++) {
                    System.out.print("---");
                    if (k < n - 1) System.out.print("+");
                }
                System.out.println();
            }
        }
        System.out.println();
    }

}
