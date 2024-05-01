package com.hs;

public class Main {
    public static void main(String[] args) {
        LoggerFactory factory = new LoggerFactory();
        Logger logger = factory.getLogger("console");
        logger.log("This is an INFO message.");
        
        logger.setLogLevel(LogLevel.DEBUG);
        logger.log("This is a DEBUG message.");
        logger.log("This is an ERROR message.");
    }
}
