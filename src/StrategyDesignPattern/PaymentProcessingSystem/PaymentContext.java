package StrategyDesignPattern.PaymentProcessingSystem;

public class PaymentContext {
    PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }
    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }

}
