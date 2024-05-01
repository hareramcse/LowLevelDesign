package com.hs;

public class LoggerFactory {
	public Logger getLogger(String type) {
		if ("console".equalsIgnoreCase(type)) {
			return new ConsoleLogger();
		} else if ("file".equalsIgnoreCase(type)) {
			return new FileLogger();
		}
		throw new IllegalArgumentException("Invalid logger type.");
	}
}
