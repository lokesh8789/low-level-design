package com.lld;

import java.util.ArrayList;
import java.util.Arrays;

public class SyncLogger extends Logger {

    public SyncLogger(LogLevel logLevel, LogAppender... logAppender) {
        super(new ArrayList<>(Arrays.asList(logAppender)), logLevel);
    }

    @Override
    protected void doLog(LogMessage logMessage) {
        logAppenders.forEach(logAppender -> logAppender.append(logMessage));
    }
}
