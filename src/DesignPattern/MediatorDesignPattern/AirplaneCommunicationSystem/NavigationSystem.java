package DesignPattern.MediatorDesignPattern.AirplaneCommunicationSystem;

public class NavigationSystem extends AirplaneComponent {
    public NavigationSystem(AirplaneControlCenter mediator, String name) {
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
