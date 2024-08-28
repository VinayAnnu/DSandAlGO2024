package DesignPattern.CommandDesignPattern;

import java.util.Stack;

public class RemoteControl {
    ICommand iCommand;
    Stack<ICommand> commandHistory = new Stack<>();

    public void setiCommand(ICommand iCommand) {
        this.iCommand = iCommand;
    }
    public void pressButton(){
        iCommand.execute();
        commandHistory.add(iCommand);
    }

    public void undo(){
        if(!commandHistory.isEmpty()){
            ICommand lastExecutedCommand = commandHistory.pop();
            lastExecutedCommand.undo();
        }
    }
}
