package com.lld;

public class RowWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWon(Integer[][] board, int x, int y, Player player) {
        for (int j = 0; j < board[x].length; j++) {
            if (board[x][j] == null || board[x][j] != player.type.ordinal()) {
                return false;
            }
        }
        return true;
    }
}
