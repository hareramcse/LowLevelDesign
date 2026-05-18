package com.hs.logappender;

import com.hs.LogMessage;

public class ConsoleAppender implements LogAppender {
	@Override
	public void append(LogMessage logMessage) {
		System.out.println(logMessage);
	}
}
