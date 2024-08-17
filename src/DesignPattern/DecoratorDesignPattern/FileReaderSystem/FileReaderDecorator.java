package DesignPattern.DecoratorDesignPattern.FileReaderSystem;

public abstract class FileReaderDecorator implements FileReader {
    protected FileReader decoratedReader;

    public FileReaderDecorator(FileReader reader){
        this.decoratedReader = reader;
    }

}
