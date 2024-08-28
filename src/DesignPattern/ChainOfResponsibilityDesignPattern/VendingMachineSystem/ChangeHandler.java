package DesignPattern.ChainOfResponsibilityDesignPattern.VendingMachineSystem;

public class ChangeHandler extends VendingHandler {
    private double itemCost = 1.50;

    @Override
    public void handleRequest(VendingRequest request) {
        double change = request.getPaymentAmount() - itemCost;
        if (change > 0) {
            System.out.println("Providing change: $" + change);
        }
        System.out.println("Thank you for your purchase!");
    }
}
