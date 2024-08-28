package DesignPattern.ChainOfResponsibilityDesignPattern.VendingMachineSystem;

public class VendingRequest {
    private String itemCode;
    private double paymentAmount;

    public VendingRequest(String itemCode, double paymentAmount) {
        this.itemCode = itemCode;
        this.paymentAmount = paymentAmount;
    }

    public String getItemCode() {
        return itemCode;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }
}
