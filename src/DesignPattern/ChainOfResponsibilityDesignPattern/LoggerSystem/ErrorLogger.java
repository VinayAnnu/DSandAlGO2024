package DesignPattern.ChainOfResponsibilityDesignPattern.LoggerSystem;

public class ErrorLogger extends Logger {
    @Override
    protected void log(LogMessage message) {
        if(message.getLevel() == LogLevel.ERROR){
            System.out.println("ERROR: " + message.getMessage());
        } else if (nextLogger != null) {
            nextLogger.log(message);
        }
    }
}
