package DesignPattern.CommandDesignPattern;

public class Client {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();
        AirConditioner ac = new AirConditioner();
        ICommand command = new TurnAcOnCommand(ac);
        remoteControl.setiCommand(command);
        remoteControl.pressButton();

        //undo the last operation
        remoteControl.undo();
    }
}
