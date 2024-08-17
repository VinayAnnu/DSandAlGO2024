package DesignPattern.NullObjectDesignPattern;

public class LoggerFactory {
    public static Logger getLoggerObject(String typeOfLogger){
        if(typeOfLogger.equals("FileLogger")){
            return new FileLogger();
        } else if (typeOfLogger.equals("ConsoleLogger")) {
            return new ConsoleLogger();
        }
        return new NullLogger();
    }
}
