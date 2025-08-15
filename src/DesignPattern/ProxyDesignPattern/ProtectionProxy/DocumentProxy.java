package DesignPattern.ProxyDesignPattern.ProtectionProxy;

public class DocumentProxy implements Document {
    private RealDocument realDocument;
    private String userRole;

    public DocumentProxy(String content, String userRole) {
        this.realDocument = new RealDocument(content);
        this.userRole = userRole;
    }

    @Override
    public void displayContent() {
        realDocument.displayContent();
    }

    @Override
    public void editContent(String newContent) {
        if ("Admin".equalsIgnoreCase(userRole)) {
            realDocument.editContent(newContent);
        } else {
            System.out.println("Access Denied: Only Admins can edit the document.");
        }
    }
}
