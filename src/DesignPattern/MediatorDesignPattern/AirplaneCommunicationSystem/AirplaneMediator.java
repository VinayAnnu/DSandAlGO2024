package DesignPattern.MediatorDesignPattern.AirplaneCommunicationSystem;

import java.util.ArrayList;
import java.util.List;

public class AirplaneMediator implements AirplaneControlCenter {
    private List<AirplaneComponent> components;

    public AirplaneMediator() {
        this.components = new ArrayList<>();
    }

    @Override
    public void registerComponent(AirplaneComponent component) {
        this.components.add(component);
    }

    @Override
    public void send(String message, AirplaneComponent sender) {
        for (AirplaneComponent component : components) {
            // Message should not be received by the component that is sending it
            if (component != sender) {
                component.receive(message);
            }
        }
    }
}
