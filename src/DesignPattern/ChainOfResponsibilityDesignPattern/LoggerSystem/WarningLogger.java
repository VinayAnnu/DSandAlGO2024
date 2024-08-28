package DesignPattern.ChainOfResponsibilityDesignPattern.LoggerSystem;

public class WarningLogger extends Logger {
    @Override
    protected void log(LogMessage message) {
        if(message.getLevel() == LogLevel.WARNING){
            System.out.println("WARN: " + message.getMessage());
        } else if (nextLogger != null) {
            nextLogger.log(message);
        }
    }
}
