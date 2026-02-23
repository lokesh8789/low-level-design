package com.lld;

public abstract class LogAppender {
    private final LogFormatter logFormatter;

    protected LogAppender(LogFormatter logFormatter) {
        this.logFormatter = logFormatter;
    }

    public final void append(LogMessage logMessage) {
        String message = logFormatter.format(logMessage);
        write(message);
    }

    protected abstract void write(String message);
}
