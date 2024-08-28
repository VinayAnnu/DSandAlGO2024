package DesignPattern.StateDesignPattern.TrafficLights;

public class RedLightState implements TrafficLightState {
    @Override
    public void changeState(TrafficLight trafficLight) {
        System.out.println("Changing from Red to Green...");
        trafficLight.setState(new GreenLightState());
    }

    @Override
    public void showLight() {
        System.out.println("Red Light - STOP!");
    }
}
