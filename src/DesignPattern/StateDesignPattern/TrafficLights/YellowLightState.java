package DesignPattern.StateDesignPattern.TrafficLights;

public class YellowLightState implements TrafficLightState {
    @Override
    public void changeState(TrafficLight trafficLight) {
        System.out.println("Changing from Yellow to Red...");
        trafficLight.setState(new RedLightState());
    }

    @Override
    public void showLight() {
        System.out.println("Yellow Light - CAUTION!");
    }
}
