package DesignPattern.StateDesignPattern.DocumentWorkflowSystems;

public class StatePatternDocumentWorkflowExample {
    public static void main(String[] args) {
        Document document = new Document();

        System.out.println("Current State: " + document.getStateName());
        document.submit();

        System.out.println("Current State: " + document.getStateName());
        document.review();

        System.out.println("Current State: " + document.getStateName());
        document.approve();

        System.out.println("Current State: " + document.getStateName());
        document.reject(); // Should not work as document is already approved

        System.out.println("Current State: " + document.getStateName());
    }
}
