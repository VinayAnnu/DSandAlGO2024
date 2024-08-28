package DesignPattern.TemplateMethodDesignPattern;

public abstract class DataProcessor {
    // Abstract methods to be implemented by subclasses
    protected abstract void readData();
    protected abstract void processData();

    // Concrete method with a default implementation
    protected void writeData() {
        System.out.println("Writing data to output...");
    }

    // Template method defining the skeleton of the algorithm. It defines the proper sequece to execute methods.
    public final void process() {
        readData();
        processData();
        writeData();
    }
}
