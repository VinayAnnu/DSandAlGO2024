package DesignPattern.ProxyDesignPattern.VirtualProxy;

public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading image from disk: " + fileName);
        // Simulate an expensive operation like loading a large image file
        try {
            Thread.sleep(2000); // Simulate a delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
}
