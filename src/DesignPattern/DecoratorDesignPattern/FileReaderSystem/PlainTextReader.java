package DesignPattern.DecoratorDesignPattern.FileReaderSystem;

import java.io.BufferedReader;
import java.io.IOException;

public class PlainTextReader implements FileReader {
    private String filePath;
    public PlainTextReader(String filePath) {
        this.filePath = filePath;
    }
    @Override
    public String read() {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
