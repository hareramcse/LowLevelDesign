package com.hs;

import com.hs.logappender.FileAppender;

public class LoggingFrameworkTest {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        logger.info("This is an information message");
        logger.warning("This is a warning message");
        logger.error("This is an error message");

        logger.setConfig(new LoggerConfig(LogLevel.DEBUG, new FileAppender("app.log")));
        logger.debug("This is a debug message");
        logger.info("This is an information message");
    }
}
