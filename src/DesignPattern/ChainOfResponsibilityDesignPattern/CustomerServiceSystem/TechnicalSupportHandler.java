package DesignPattern.ChainOfResponsibilityDesignPattern.CustomerServiceSystem;

class TechnicalSupportHandler extends SupportHandler {
    @Override
    public void handleRequest(SupportRequest request) {
        if (request.getUrgency() == UrgencyLevel.MEDIUM) {
            System.out.println("Technical Support handling request: " + request.getMessage());
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
