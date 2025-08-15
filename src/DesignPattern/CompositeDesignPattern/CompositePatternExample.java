package DesignPattern.CompositeDesignPattern;

public class CompositePatternExample {
    public static void main(String[] args) {
        FileSystemComponent file1 = new File("Document.txt", 20);
        FileSystemComponent file2 = new File("Photo.jpg", 1500);
        FileSystemComponent file3 = new File("Video.mp4", 20000);

        Folder folder1 = new Folder("Documents");
        folder1.addComponent(file1);

        Folder folder2 = new Folder("Media");
        folder2.addComponent(file2);
        folder2.addComponent(file3);

        Folder rootFolder = new Folder("Root");
        rootFolder.addComponent(folder1);
        rootFolder.addComponent(folder2);

        System.out.println("Showing details of root folder:");
        rootFolder.showDetails();

        System.out.println("\nTotal size of root folder: " + rootFolder.getSize() + " KB");
    }
}
