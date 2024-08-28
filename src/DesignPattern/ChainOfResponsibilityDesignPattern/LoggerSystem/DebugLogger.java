package DesignPattern.ChainOfResponsibilityDesignPattern.LoggerSystem;

public class DebugLogger extends Logger {
    @Override
    protected void log(LogMessage message) {
        if(message.getLevel() == LogLevel.DEBUG){
            System.out.println("DEBUG: " + message.getMessage());
        } else if (nextLogger != null) {
            nextLogger.log(message);
        }
    }
}
