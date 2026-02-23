package com.lld;

import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n*************** Logging System ***************\n");

        Logger asyncLogger = new AsyncLogger(LogLevel.INFO, new ConsoleAppender(new DefaultFormatter()), new FileAppender(new JsonFormatter(), Path.of("json.txt")));
        asyncLogger.info("Async Info");
        asyncLogger.trace("Async Trace");

        Logger syncLogger = new SyncLogger(LogLevel.TRACE, new ConsoleAppender(new DefaultFormatter()));
        syncLogger.info("Sync Info");
        syncLogger.trace("Sync Trace");
    }
}