package com.lld;

public class DiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWon(Integer[][] board, int x, int y, Player player) {
        if (x != y) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == null || board[i][i] != player.type.ordinal()) {
                return false;
            }
        }
        return true;
    }
}
