package StrategyDesignPattern.PaymentProcessingSystem;

public class CreditCardPaymentStrategy implements PaymentStrategy{

    private String cardNumber;
    private String cardHolderName;

    public CreditCardPaymentStrategy(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }
    @Override
    public void pay(double amount) {
        // Logic to process payment using a credit card
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}
