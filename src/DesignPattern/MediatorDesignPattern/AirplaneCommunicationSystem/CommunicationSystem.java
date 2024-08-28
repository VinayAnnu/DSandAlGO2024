package DesignPattern.MediatorDesignPattern.AirplaneCommunicationSystem;

public class CommunicationSystem extends AirplaneComponent {
    public CommunicationSystem(AirplaneControlCenter mediator, String name) {
        super(mediator, name);
    }

    @Override
    public void send(String message) {
        System.out.println(this.name + " sends: " + message);
        mediator.send(message, this);
    }

    @Override
    public void receive(String message) {
        System.out.println(this.name + " receives: " + message);
    }
}
