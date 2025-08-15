package DesignPattern.FlyweightDesignPattern.TextEditor;

public class FlyweightPatternExample {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();

        // These characters are shared
        CharacterFlyweight charA = factory.getCharacter('A');
        CharacterFlyweight charB = factory.getCharacter('B');
        CharacterFlyweight charC = factory.getCharacter('C');

        // These characters are reused
        charA.display(12, "Red");
        charB.display(14, "Blue");
        charA.display(16, "Green"); // Reusing 'A' with different extrinsic state
        charC.display(18, "Yellow");
    }
}
