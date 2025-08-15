package DesignPattern.CompositeDesignPattern;

public class File implements FileSystemComponent {
    private String name;
    private int size; // Size in kilobytes

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public void showDetails() {
        System.out.println("File: " + name + " [Size: " + size + " KB]");
    }

    @Override
    public int getSize() {
        return size;
    }
}
