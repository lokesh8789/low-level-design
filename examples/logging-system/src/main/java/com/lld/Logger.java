package com.lld;

import java.time.LocalDateTime;
import java.util.List;

public abstract class Logger {
    protected final List<LogAppender> logAppenders;
    protected final LogLevel logLevel;

    protected Logger(List<LogAppender> logAppenders, LogLevel logLevel) {
        this.logAppenders = logAppenders;
        this.logLevel = logLevel;
    }

    protected boolean isEnabled(LogLevel level) {
        return level.getPriority() >= logLevel.getPriority();
    }

    public final void log(LogLevel level, String message) {
        if (!isEnabled(level)) {
            return;
        }
        doLog(new LogMessage(message, LocalDateTime.now(), level));
    }

    protected abstract void doLog(LogMessage logMessage);

    public void error(String message) {
        log(LogLevel.ERROR, message);
    }

    public void warn(String message) {
        log(LogLevel.WARN, message);
    }

    public void info(String message) {
        log(LogLevel.INFO, message);
    }

    public void debug(String message) {
        log(LogLevel.DEBUG, message);
    }

    public void trace(String message) {
        log(LogLevel.TRACE, message);
    }
}
