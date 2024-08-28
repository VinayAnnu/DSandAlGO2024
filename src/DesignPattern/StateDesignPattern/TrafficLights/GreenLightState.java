package DesignPattern.StateDesignPattern.TrafficLights;

public class GreenLightState implements TrafficLightState {
    @Override
    public void changeState(TrafficLight trafficLight) {
        System.out.println("Changing from Green to Yellow...");
        trafficLight.setState(new YellowLightState());
    }

    @Override
    public void showLight() {
        System.out.println("Green Light - GO!");
    }
}
