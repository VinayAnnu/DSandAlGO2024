package DesignPattern.ChainOfResponsibilityDesignPattern.CustomerServiceSystem;

public class ManagerHandler extends SupportHandler {
    @Override
    public void handleRequest(SupportRequest request) {
        if (request.getUrgency() == UrgencyLevel.HIGH) {
            System.out.println("Manager handling request: " + request.getMessage());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
