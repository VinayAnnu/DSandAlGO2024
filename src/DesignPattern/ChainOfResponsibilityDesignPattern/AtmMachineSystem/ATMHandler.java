package DesignPattern.ChainOfResponsibilityDesignPattern.AtmMachineSystem;

public abstract class ATMHandler {
    protected ATMHandler nextHandler;

    public void setNextHandler(ATMHandler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public abstract void handleRequest(ATMRequest request);
}
