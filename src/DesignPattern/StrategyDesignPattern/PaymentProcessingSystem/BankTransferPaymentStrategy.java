package DesignPattern.StrategyDesignPattern.PaymentProcessingSystem;

public class BankTransferPaymentStrategy implements PaymentStrategy {
    private String bankAccount;

    public BankTransferPaymentStrategy(String bankAccount) {
        this.bankAccount = bankAccount;
    }
    @Override
    public void pay(double amount) {
        // Logic to process payment using a bank transfer
        System.out.println("Paid " + amount + " using Bank Transfer.");
    }
}
