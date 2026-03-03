package com.lld;

public abstract class Player {
    protected String name;
    protected PlayerType type;

    protected Player(String name, PlayerType type) {
        this.name = name;
        this.type = type;
    }
}
