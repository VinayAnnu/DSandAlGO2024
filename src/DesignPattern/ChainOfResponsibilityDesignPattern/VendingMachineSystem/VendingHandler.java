package DesignPattern.ChainOfResponsibilityDesignPattern.VendingMachineSystem;

public abstract class VendingHandler {
    protected VendingHandler nextHandler;

    public void setNextHandler(VendingHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract void handleRequest(VendingRequest request);
}
