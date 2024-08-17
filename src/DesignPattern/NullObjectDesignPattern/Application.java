package DesignPattern.NullObjectDesignPattern;

public class Application {
    public static void main(String[] args) {
        Logger consolelogger = LoggerFactory.getLoggerObject("ConsoleLogger");
        consolelogger.log("Doing some thing important on CONSOLE");

        Logger filelogger = LoggerFactory.getLoggerObject("FileLogger");
        filelogger.log("Doing some thing important on FILE");

        // Using a NullLogger (logging disabled)
        Logger disablelogger = LoggerFactory.getLoggerObject("anything");
        disablelogger.log("Do nothing");
    }
}
