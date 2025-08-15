package DesignPattern.ProxyDesignPattern.ProtectionProxy;

public class RealDocument implements Document {
    private String content;
    public RealDocument(String content) {
        this.content = content;
    }
    @Override
    public void displayContent() {
        System.out.println("Document Content: " + content);
    }

    @Override
    public void editContent(String newContent) {
        this.content = newContent;
        System.out.println("Document Content updated to: " + content);
    }
}
