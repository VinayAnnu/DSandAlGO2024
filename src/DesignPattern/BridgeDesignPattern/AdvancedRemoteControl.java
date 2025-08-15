package DesignPattern.BridgeDesignPattern;

public class AdvancedRemoteControl extends RemoteControl {
    public AdvancedRemoteControl(Device device) {
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
        System.out.println("Advanced remote: Channel selection with extra features.");
        device.setChannel(channel);
    }

    public void mute() {
        System.out.println("Muting the device.");
        // Additional functionality specific to advanced remote
    }
}
