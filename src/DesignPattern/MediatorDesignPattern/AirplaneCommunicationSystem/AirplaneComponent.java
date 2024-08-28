package DesignPattern.MediatorDesignPattern.AirplaneCommunicationSystem;

public abstract class AirplaneComponent {
    protected AirplaneControlCenter mediator;
    protected String name;

    public AirplaneComponent(AirplaneControlCenter mediator, String name) {
        this.mediator = mediator;
        this.name = name;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}
