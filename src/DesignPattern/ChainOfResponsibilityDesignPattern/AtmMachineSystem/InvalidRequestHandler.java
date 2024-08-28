package DesignPattern.ChainOfResponsibilityDesignPattern.AtmMachineSystem;

public class InvalidRequestHandler extends ATMHandler {
    @Override
    public void handleRequest(ATMRequest request) {
        System.out.println("Invalid request: " + request.getOperationType());
        // Handle invalid operations
    }
}
