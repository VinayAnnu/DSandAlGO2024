package DesignPattern.ProxyDesignPattern.VirtualProxy;

public class VirtualProxyExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Image will be loaded and displayed now
        image1.display();
        System.out.println();

        // Image will not be loaded again, just displayed
        image1.display();
        System.out.println();

        // Image2 will be loaded and displayed now
        image2.display();
    }
}
