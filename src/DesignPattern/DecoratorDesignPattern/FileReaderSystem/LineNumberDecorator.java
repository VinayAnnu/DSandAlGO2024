package DesignPattern.DecoratorDesignPattern.FileReaderSystem;

public class LineNumberDecorator extends FileReaderDecorator {
    public LineNumberDecorator(FileReader reader) {
        super(reader);
    }

    @Override
    public String read() {
        String content = decoratedReader.read();
        String[] lines = content.split("\n");
        StringBuilder numberedContent = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            numberedContent.append(i + 1).append(": ").append(lines[i]).append("\n");
        }
        return numberedContent.toString();
    }
}
