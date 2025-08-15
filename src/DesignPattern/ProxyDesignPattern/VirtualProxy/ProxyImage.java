package DesignPattern.ProxyDesignPattern.VirtualProxy;

public class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);  // Load the real image only when it's needed
        }
        realImage.display();
    }
}
