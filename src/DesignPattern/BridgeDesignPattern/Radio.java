package DesignPattern.BridgeDesignPattern;

public class Radio implements Device {
    private boolean on;
    private int station;
    @Override
    public void powerOn() {
        on = true;
        System.out.println("Radio is powered on.");
    }

    @Override
    public void powerOff() {
        on = false;
        System.out.println("Radio is powered off.");
    }

    @Override
    public void setChannel(int station) {
        if (on) {
            this.station = station;
            System.out.println("Radio station set to " + station);
        } else {
            System.out.println("Cannot change station. Radio is off.");
        }
    }

    @Override
    public boolean isPoweredOn() {
        return on;
    }
}
