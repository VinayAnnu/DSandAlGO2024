package DesignPattern.StateDesignPattern.TrafficLights;

public class TrafficLight {
    private TrafficLightState state;

    public TrafficLight() {
        // Initial state is Red
        this.state = new RedLightState();
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void changeState() {
        state.changeState(this);
    }

    public void showLight() {
        state.showLight();
    }
}
