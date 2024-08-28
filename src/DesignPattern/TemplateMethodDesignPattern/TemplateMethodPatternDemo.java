package DesignPattern.TemplateMethodDesignPattern;

public class TemplateMethodPatternDemo {
    public static void main(String[] args) {
        DataProcessor csvProcessor = new CSVDataProcessor();
        csvProcessor.process();  // Process CSV data

        System.out.println();

        DataProcessor jsonProcessor = new JSONDataProcessor();
        jsonProcessor.process();  // Process JSON data
    }
}
