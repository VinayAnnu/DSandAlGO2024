package DesignPattern.ProxyDesignPattern.ProtectionProxy;

public class ProtectionProxyPatternExample {
    public static void main(String[] args) {
        Document userDocument = new DocumentProxy("Confidential Document Content", "User");
        Document adminDocument = new DocumentProxy("Confidential Document Content", "Admin");

        System.out.println("User View:");
        userDocument.displayContent();
        userDocument.editContent("User tries to edit");

        System.out.println("\nAdmin View:");
        adminDocument.displayContent();
        adminDocument.editContent("Admin edits content");

        System.out.println("\nAdmin View:");
        adminDocument.displayContent();

        System.out.println("\nUser View:");
        userDocument.displayContent();
    }
}
