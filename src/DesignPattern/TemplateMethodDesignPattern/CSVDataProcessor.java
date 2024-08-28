package DesignPattern.TemplateMethodDesignPattern;

public class CSVDataProcessor extends DataProcessor {
    @Override
    protected void readData() {
        System.out.println("Reading data from CSV file...");
    }

    @Override
    protected void processData() {
        System.out.println("Processing CSV data...");
    }

//    protected void writeData() {
//        System.out.println("Writing data to CSVDataProcessor output...");
//    }
}
