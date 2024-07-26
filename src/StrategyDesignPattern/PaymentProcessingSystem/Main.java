package StrategyDesignPattern.PaymentProcessingSystem;

public class Main {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        // Paying with Credit Card
        paymentContext.setPaymentStrategy(new CreditCardPaymentStrategy("123456789", "John Doe"));
        paymentContext.executePayment(100.0);

        // Paying with PayPal
        paymentContext.setPaymentStrategy(new PayPalPaymentStrategy("john@example.com"));
        paymentContext.executePayment(150.0);

        // Paying with Bank Transfer
        paymentContext.setPaymentStrategy(new BankTransferPaymentStrategy("987654321"));
        paymentContext.executePayment(200.0);
    }
}
