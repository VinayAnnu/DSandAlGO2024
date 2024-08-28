package DesignPattern.ChainOfResponsibilityDesignPattern.LoggerSystem;

public class InfoLogger extends Logger {
    @Override
    protected void log(LogMessage message) {
        if(message.getLevel() == LogLevel.INFO){
            System.out.println("INFO: " + message.getMessage());
        } else if (nextLogger != null) {
            nextLogger.log(message);
        }
    }
}
