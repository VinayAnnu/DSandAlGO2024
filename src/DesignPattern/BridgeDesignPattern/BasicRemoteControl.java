package DesignPattern.BridgeDesignPattern;

public class BasicRemoteControl extends RemoteControl {
    public BasicRemoteControl(Device device) {
        super(device);
    }

    @Override
    public void togglePower() {
        if (device.isPoweredOn()) {
            device.powerOff();
        } else {
            device.powerOn();
        }
    }

    @Override
    public void setChannel(int channel) {
        device.setChannel(channel);
    }
}
