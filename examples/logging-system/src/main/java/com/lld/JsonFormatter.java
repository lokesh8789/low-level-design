package com.lld;

public class JsonFormatter implements LogFormatter {
    @Override
    public String format(LogMessage message) {
        return """
                {
                    "level": "%s",
                    "timestamp": "%s",
                    "message": "%s"
                }
                """.formatted(message.getLevel(), message.getTimestamp(), message.getMessage());
    }
}
