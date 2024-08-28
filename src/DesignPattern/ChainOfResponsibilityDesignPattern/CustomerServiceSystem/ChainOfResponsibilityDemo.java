package DesignPattern.ChainOfResponsibilityDesignPattern.CustomerServiceSystem;

public class ChainOfResponsibilityDemo {
    public static void main(String[] args) {
        // Create handlers
        SupportHandler customerService = new CustomerServiceHandler();
        SupportHandler technicalSupport = new TechnicalSupportHandler();
        SupportHandler manager = new ManagerHandler();

        // Set up the chain
        customerService.setNextHandler(technicalSupport);
        technicalSupport.setNextHandler(manager);

        // Create and process requests
        SupportRequest request1 = new SupportRequest("Need help with logging in.", UrgencyLevel.LOW);
        customerService.handleRequest(request1);

        SupportRequest request2 = new SupportRequest("System crash issue!", UrgencyLevel.HIGH);
        customerService.handleRequest(request2);

        SupportRequest request3 = new SupportRequest("Feature not working as expected.", UrgencyLevel.MEDIUM);
        customerService.handleRequest(request3);
    }
}
