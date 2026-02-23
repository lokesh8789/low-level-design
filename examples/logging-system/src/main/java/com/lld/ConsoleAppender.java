package com.lld;

public class ConsoleAppender extends LogAppender {

    public ConsoleAppender(LogFormatter logFormatter) {
        super(logFormatter);
    }

    @Override
    protected void write(String message) {
        System.out.println(message);
    }
}
