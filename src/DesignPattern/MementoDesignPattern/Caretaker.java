package DesignPattern.MementoDesignPattern;

import java.util.Stack;

public class Caretaker {
    private Stack<Memento> undoStack = new Stack<>();
    private Stack<Memento> redoStack = new Stack<>();

    public void saveState(TextEditor textEditor) {
        undoStack.push(textEditor.save());
        redoStack.clear(); // Clear redo stack after new operation
    }

    public void undo(TextEditor textEditor) {
        if (!undoStack.isEmpty()) {
            Memento currentState = textEditor.save(); // Save current state before undoing
            Memento previousState = undoStack.pop(); // Pop last state from undo stack
            redoStack.push(currentState); // Push current state to redo stack
            textEditor.restore(previousState); // Restore text to previous state
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void redo(TextEditor textEditor) {
        if (!redoStack.isEmpty()) {
            Memento currentState = textEditor.save(); // Save current state before redoing
            Memento redoState = redoStack.pop(); // Pop the last state from redo stack
            undoStack.push(currentState); // Push current state to undo stack
            textEditor.restore(redoState); // Restore text to redo state
        } else {
            System.out.println("Nothing to redo.");
        }
    }
}
