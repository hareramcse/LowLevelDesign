package com.hs;

public class FileLogger implements Logger {
	private LogLevel logLevel = LogLevel.INFO;

    @Override
    public void log(String message) {
        if (LogLevel.INFO.equals(logLevel)) {
            System.out.println("[Console] " + message);
        }else if (LogLevel.DEBUG.equals(logLevel)) {
			System.out.println("[Console] " + message);
		}
    }

    @Override
    public void setLogLevel(LogLevel level) {
        this.logLevel = level;
    }
}