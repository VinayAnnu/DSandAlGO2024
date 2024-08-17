package DesignPattern.NullObjectDesignPattern;

public class FileLogger implements Logger {
    @Override
    public void log(String message) {
        // Simulate writing to a file
        System.out.println("FileLogger: " + message);
    }
}
