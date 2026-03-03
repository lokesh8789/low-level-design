package com.lld;

public interface WinningStrategy {
    boolean checkWon(Integer[][] board, int x, int y, Player player);
}
