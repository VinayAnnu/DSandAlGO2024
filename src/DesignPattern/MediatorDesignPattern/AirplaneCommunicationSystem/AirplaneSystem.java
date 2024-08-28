package DesignPattern.MediatorDesignPattern.AirplaneCommunicationSystem;

public class AirplaneSystem {
    public static void main(String[] args) {
        AirplaneControlCenter mediator = new AirplaneMediator();

        AirplaneComponent pilot = new Pilot(mediator, "Pilot");
        AirplaneComponent coPilot = new CoPilot(mediator, "CoPilot");
        AirplaneComponent navigationSystem = new NavigationSystem(mediator, "Navigation System");
        AirplaneComponent communicationSystem = new CommunicationSystem(mediator, "Communication System");

        mediator.registerComponent(pilot);
        mediator.registerComponent(coPilot);
        mediator.registerComponent(navigationSystem);
        mediator.registerComponent(communicationSystem);

        pilot.send("Ready for takeoff.");
        System.out.println("--------------------------------");
        communicationSystem.send("Clear for takeoff.");
    }
}
