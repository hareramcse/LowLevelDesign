package com.hs.logappender;

import com.hs.LogMessage;

public interface LogAppender {
    void append(LogMessage logMessage);
}
