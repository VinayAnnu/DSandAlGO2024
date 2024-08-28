package DesignPattern.CommandDesignPattern;

public class TurnAcOffCommand implements ICommand {
    AirConditioner ac;

    public TurnAcOffCommand(AirConditioner ac) {
        this.ac = ac;
    }

    @Override
    public void execute() {
        ac.turnOffAc();
    }

    @Override
    public void undo() {
        ac.turnOnAc();
    }
}
