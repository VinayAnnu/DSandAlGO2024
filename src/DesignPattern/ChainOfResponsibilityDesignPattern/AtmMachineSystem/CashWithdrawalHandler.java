package DesignPattern.ChainOfResponsibilityDesignPattern.AtmMachineSystem;

public class CashWithdrawalHandler extends ATMHandler {
    @Override
    public void handleRequest(ATMRequest request) {
        if (request.getOperationType().equalsIgnoreCase("withdraw")) {
            System.out.println("Processing cash withdrawal of amount: " + request.getAmount());
            // Add logic to handle cash withdrawal, e.g., check balance, dispense cash, etc.
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
