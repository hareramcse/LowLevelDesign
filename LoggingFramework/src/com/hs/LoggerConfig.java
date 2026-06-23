package com.hs;

import com.hs.logappender.LogAppender;

public record LoggerConfig(LogLevel logLevel, LogAppender appender) {}
