package com.hs;

public record LogMessage(LogLevel level, String message, long timestamp) {
    public LogMessage(LogLevel level, String message) {
        this(level, message, System.currentTimeMillis());
    }

    @Override
    public String toString() {
        return "[" + level + "] " + timestamp + " - " + message;
    }
}
