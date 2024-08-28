package DesignPattern.StateDesignPattern.TrafficLights;

public interface TrafficLightState {
    void changeState(TrafficLight trafficLight);
    void showLight();
}
