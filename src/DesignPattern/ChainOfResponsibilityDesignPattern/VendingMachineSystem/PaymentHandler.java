package DesignPattern.ChainOfResponsibilityDesignPattern.VendingMachineSystem;

public class PaymentHandler extends VendingHandler {
    private double itemCost = 1.50; // Let's assume a fixed cost for simplicity
    @Override
    public void handleRequest(VendingRequest request) {
        if (request.getPaymentAmount() >= itemCost) {
            System.out.println("Payment accepted.");
            if (nextHandler != null) {
                nextHandler.handleRequest(request);
            }
        } else {
            System.out.println("Insufficient payment. Please insert more money.");
        }
    }
}
