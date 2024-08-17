package DesignPattern.DecoratorDesignPattern.FileReaderSystem;

public class FileReaderDemo {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.home"));
        FileReader fileReader = new PlainTextReader("/Users/vinaykumarranjan/Documents/Test/sample.txt");

        // Reading plain text
        System.out.println("Plain Text:");
        System.out.println(fileReader.read());

        // Adding Uppercase functionality
        fileReader = new UpperCaseDecorator(fileReader);
        System.out.println("Uppercase Text:");
        System.out.println(fileReader.read());

        // Adding Line Number functionality
        fileReader = new LineNumberDecorator(fileReader);
        System.out.println("Line Numbered Text:");
        System.out.println(fileReader.read());

        // Adding Word Count functionality
        fileReader = new WordCountDecorator(fileReader);
        System.out.println("Text with Word Count:");
        System.out.println(fileReader.read());
    }
}
