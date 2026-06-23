package com.hs;

import com.hs.logappender.ConsoleAppender;

public class Logger {
    private static final Logger INSTANCE = new Logger();
    private LoggerConfig config = new LoggerConfig(LogLevel.INFO, new ConsoleAppender());

    private Logger() {}

    public static Logger getInstance() { return INSTANCE; }

    public void setConfig(LoggerConfig config) { this.config = config; }

    public void log(LogLevel level, String message) {
        if (level.ordinal() >= config.logLevel().ordinal()) {
            config.appender().append(new LogMessage(level, message));
        }
    }

    public void debug(String message) { log(LogLevel.DEBUG, message); }
    public void info(String message) { log(LogLevel.INFO, message); }
    public void warning(String message) { log(LogLevel.WARNING, message); }
    public void error(String message) { log(LogLevel.ERROR, message); }
}
