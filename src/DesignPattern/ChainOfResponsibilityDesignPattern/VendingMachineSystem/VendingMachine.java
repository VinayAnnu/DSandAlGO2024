package DesignPattern.ChainOfResponsibilityDesignPattern.VendingMachineSystem;

public class VendingMachine {
    public static void main(String[] args) {
        // Create handlers
        VendingHandler paymentHandler = new PaymentHandler();
        VendingHandler inventoryHandler = new InventoryHandler();
        VendingHandler dispenseItemHandler = new DispenseItemHandler();
        VendingHandler changeHandler = new ChangeHandler();

        // Set up the chain
        paymentHandler.setNextHandler(inventoryHandler);
        inventoryHandler.setNextHandler(dispenseItemHandler);
        dispenseItemHandler.setNextHandler(changeHandler);

        // Create and process requests
        VendingRequest request1 = new VendingRequest("A1", 2.00);
        paymentHandler.handleRequest(request1);

        VendingRequest request2 = new VendingRequest("A2", 2.00);  // Item out of stock
        paymentHandler.handleRequest(request2);

        VendingRequest request3 = new VendingRequest("B1", 1.00);  // Insufficient payment
        paymentHandler.handleRequest(request3);
    }
}
