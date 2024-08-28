package DesignPattern.ChainOfResponsibilityDesignPattern.AtmMachineSystem;

public class ATMRequest {
    private String operationType;
    private double amount; // Used for withdrawal, deposit, etc.

    public ATMRequest(String operationType, double amount) {
        this.operationType = operationType;
        this.amount = amount;
    }

    public String getOperationType() {
        return operationType;
    }

    public double getAmount() {
        return amount;
    }
}
