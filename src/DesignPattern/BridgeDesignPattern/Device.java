package DesignPattern.BridgeDesignPattern;

public interface Device {
    void powerOn();
    void powerOff();
    void setChannel(int channel);
    boolean isPoweredOn();
}
