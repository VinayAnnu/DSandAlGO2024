package DesignPattern.ChainOfResponsibilityDesignPattern.AtmMachineSystem;

public class DepositMoneyHandler extends ATMHandler {
    @Override
    public void handleRequest(ATMRequest request) {
        if (request.getOperationType().equalsIgnoreCase("deposit")) {
            System.out.println("Processing deposit of amount: " + request.getAmount());
            // Add logic to handle deposit, e.g., update account balance.
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
