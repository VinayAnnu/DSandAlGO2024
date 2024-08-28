package DesignPattern.ChainOfResponsibilityDesignPattern.AtmMachineSystem;

public class PINChangeHandler extends ATMHandler {
    @Override
    public void handleRequest(ATMRequest request) {
        if (request.getOperationType().equalsIgnoreCase("pinchange")) {
            System.out.println("Processing PIN change...");
            // Add logic to handle PIN change.
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
