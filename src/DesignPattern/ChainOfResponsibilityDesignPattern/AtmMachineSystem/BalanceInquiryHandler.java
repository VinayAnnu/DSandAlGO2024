package DesignPattern.ChainOfResponsibilityDesignPattern.AtmMachineSystem;

public class BalanceInquiryHandler extends ATMHandler {
    @Override
    public void handleRequest(ATMRequest request) {
        if (request.getOperationType().equalsIgnoreCase("balance")) {
            System.out.println("Processing balance inquiry...");
            // Add logic to handle balance inquiry, e.g., retrieve balance from the account.
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
