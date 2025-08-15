package DesignPattern.BridgeDesignPattern;

public class BridgePatternExample {
    public static void main(String[] args) {
        Device tv = new TV();
        RemoteControl basicRemote = new BasicRemoteControl(tv);
        basicRemote.togglePower();
        basicRemote.setChannel(5);

        Device radio = new Radio();
        RemoteControl advancedRemote = new AdvancedRemoteControl(radio);
        advancedRemote.togglePower();
        advancedRemote.setChannel(3);
        ((AdvancedRemoteControl) advancedRemote).mute();
    }
}
