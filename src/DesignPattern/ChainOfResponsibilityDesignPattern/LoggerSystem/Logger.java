package DesignPattern.ChainOfResponsibilityDesignPattern.LoggerSystem;

public abstract class Logger {
    protected Logger nextLogger;

    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    protected abstract void log(LogMessage message);
}
