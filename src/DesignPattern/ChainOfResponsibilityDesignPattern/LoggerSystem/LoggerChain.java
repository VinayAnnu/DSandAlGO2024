package DesignPattern.ChainOfResponsibilityDesignPattern.LoggerSystem;

public class LoggerChain {
    public static void main(String[] args) {
        // Create loggers
        Logger debugLogger = new DebugLogger();
        Logger infoLogger = new InfoLogger();
        Logger warningLogger = new WarningLogger();
        Logger errorLogger = new ErrorLogger();

        // Set up the chain
        debugLogger.setNextLogger(infoLogger);
        infoLogger.setNextLogger(warningLogger);
        warningLogger.setNextLogger(errorLogger);

        // Create and process log messages
        LogMessage message1 = new LogMessage("This is a debug message.", LogLevel.DEBUG);
        debugLogger.log(message1);

        LogMessage message2 = new LogMessage("This is an info message.", LogLevel.INFO);
        debugLogger.log(message2);

        LogMessage message3 = new LogMessage("This is a warning message.", LogLevel.WARNING);
        debugLogger.log(message3);

        LogMessage message4 = new LogMessage("This is an error message.", LogLevel.ERROR);
        debugLogger.log(message4);
    }
}
