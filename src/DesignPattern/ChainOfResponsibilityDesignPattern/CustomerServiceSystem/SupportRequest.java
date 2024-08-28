package DesignPattern.ChainOfResponsibilityDesignPattern.CustomerServiceSystem;

public class SupportRequest {
    private String message;
    private UrgencyLevel urgency;

    public SupportRequest(String message, UrgencyLevel urgency) {
        this.message = message;
        this.urgency = urgency;
    }

    public String getMessage() {
        return message;
    }

    public UrgencyLevel getUrgency() {
        return urgency;
    }
}
