package DesignPattern.ChainOfResponsibilityDesignPattern.CustomerServiceSystem;

public class CustomerServiceHandler extends SupportHandler {
    @Override
    public void handleRequest(SupportRequest request) {
        if(request.getUrgency() == UrgencyLevel.LOW){
            System.out.println("Customer Service handling request: " + request.getMessage());
        } else if(nextHandler != null){
            nextHandler.handleRequest(request);
        }
    }
}
