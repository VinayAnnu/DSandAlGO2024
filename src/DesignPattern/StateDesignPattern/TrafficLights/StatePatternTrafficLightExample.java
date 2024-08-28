package DesignPattern.StateDesignPattern.TrafficLights;

public class StatePatternTrafficLightExample {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();

        // Simulate traffic light cycles
        for (int i = 0; i < 5; i++) {
            trafficLight.showLight(); // Show the current light
            trafficLight.changeState(); // Change to the next state
            System.out.println("----------");
        }
    }
}
