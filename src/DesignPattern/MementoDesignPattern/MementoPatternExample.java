package DesignPattern.MementoDesignPattern;

public class MementoPatternExample {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        Caretaker caretaker = new Caretaker();

        textEditor.setText("Hello");
        caretaker.saveState(textEditor);
        System.out.println("Text: " + textEditor.getText());

        textEditor.setText("Hello, World");
        caretaker.saveState(textEditor);
        System.out.println("Text: " + textEditor.getText());

        caretaker.undo(textEditor);
        System.out.println("After undo, Text: " + textEditor.getText());

        caretaker.undo(textEditor);
        System.out.println("After another undo, Text: " + textEditor.getText());

        caretaker.redo(textEditor);
        System.out.println("After redo, Text: " + textEditor.getText());

    }
}
