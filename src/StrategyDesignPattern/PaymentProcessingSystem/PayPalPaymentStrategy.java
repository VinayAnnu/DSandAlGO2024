package StrategyDesignPattern.PaymentProcessingSystem;

public class PayPalPaymentStrategy implements PaymentStrategy {
    private String email;

    public PayPalPaymentStrategy(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        // Logic to process payment using PayPal
        System.out.println("Paid " + amount + " using PayPal.");
    }
}
