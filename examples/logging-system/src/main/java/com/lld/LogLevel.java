package com.lld;

public enum LogLevel {
    ERROR(5),
    WARN(4),
    INFO(3),
    DEBUG(2),
    TRACE(1);

    private final int priority;

    LogLevel(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
