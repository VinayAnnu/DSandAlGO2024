package DesignPattern.BridgeDesignPattern;

public class TV implements Device {
    private boolean on;
    private int channel;

    @Override
    public void powerOn() {
        on = true;
        System.out.println("TV is powered on.");
    }

    @Override
    public void powerOff() {
        on = false;
        System.out.println("TV is powered off.");
    }

    @Override
    public void setChannel(int channel) {
        if (on) {
            this.channel = channel;
            System.out.println("TV channel set to " + channel);
        } else {
            System.out.println("Cannot change channel. TV is off.");
        }
    }

    @Override
    public boolean isPoweredOn() {
        return on;
    }
}
