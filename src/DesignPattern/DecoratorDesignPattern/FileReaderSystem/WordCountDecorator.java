package DesignPattern.DecoratorDesignPattern.FileReaderSystem;

public class WordCountDecorator extends FileReaderDecorator {
    public WordCountDecorator(FileReader reader) {
        super(reader);
    }

    @Override
    public String read() {
        String content = decoratedReader.read();
        int wordCount = content.split("\\s+").length;
        return content + "\nWord Count: " + wordCount;
    }
}
