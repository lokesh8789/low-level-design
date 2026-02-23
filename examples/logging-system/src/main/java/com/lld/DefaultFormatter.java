package com.lld;

public class DefaultFormatter implements LogFormatter {

    @Override
    public String format(LogMessage message) {
        return message.getLevel() + " | " + message.getTimestamp() + " | " + message.getMessage();
    }
}
