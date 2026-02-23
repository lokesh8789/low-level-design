package com.lld;

import java.time.LocalDateTime;

public class LogMessage {
    private String message;
    private LocalDateTime timestamp;
    private LogLevel level;

    public LogMessage(String message, LocalDateTime timestamp, LogLevel level) {
        this.message = message;
        this.timestamp = timestamp;
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }
}
