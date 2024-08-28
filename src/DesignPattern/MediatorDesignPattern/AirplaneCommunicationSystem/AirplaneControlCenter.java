package DesignPattern.MediatorDesignPattern.AirplaneCommunicationSystem;

public interface AirplaneControlCenter {
    void send(String message, AirplaneComponent component);
    void registerComponent(AirplaneComponent component);
}
