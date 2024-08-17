package DesignPattern.DecoratorDesignPattern.FileReaderSystem;

public class UpperCaseDecorator extends FileReaderDecorator {
    public UpperCaseDecorator(FileReader reader) {
        super(reader);
    }

    @Override
    public String read() {
        String content = decoratedReader.read();
        return content.toUpperCase();
    }
}
