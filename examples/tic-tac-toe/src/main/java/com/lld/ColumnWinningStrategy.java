package com.lld;

public class ColumnWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWon(Integer[][] board, int x, int y, Player player) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][y] == null || board[i][y] != player.type.ordinal()) {
                return false;
            }
        }
        return true;
    }
}
