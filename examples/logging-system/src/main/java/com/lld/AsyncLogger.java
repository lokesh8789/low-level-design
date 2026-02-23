package com.lld;

import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class AsyncLogger extends Logger {
    private final BlockingQueue<LogMessage> queue;

    public AsyncLogger(LogLevel logLevel, LogAppender... logAppender) {
        super(new CopyOnWriteArrayList<>(Arrays.asList(logAppender)), logLevel);
        this.queue = new LinkedBlockingQueue<>();
        start();
    }

    @Override
    protected void doLog(LogMessage logMessage) {
        queue.offer(logMessage);
    }

    public void start() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    LogMessage logMessage = queue.take();
                    logAppenders.forEach(logAppender -> logAppender.append(logMessage));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        thread.start();
    }
}
