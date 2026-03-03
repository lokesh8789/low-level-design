package com.lld;

public class AntiDiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWon(Integer[][] board, int x, int y, Player player) {
        int n = board.length;
        if (x + y != n - 1) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (board[i][n - 1 - i] == null || board[i][n - 1 - i] != player.type.ordinal()) {
                return false;
            }
        }
        return true;
    }
}
