package DesignPattern.FlyweightDesignPattern.TextEditor;

public class CharacterImpl implements CharacterFlyweight {
    private final char character; // Intrinsic state

    public CharacterImpl(char character) {
        this.character = character;
    }
    @Override
    public void display(int fontSize, String color) {
        // Extrinsic state: fontSize and color
        System.out.println("Character: " + character + " | Font Size: " + fontSize + " | Color: " + color);
    }
}
