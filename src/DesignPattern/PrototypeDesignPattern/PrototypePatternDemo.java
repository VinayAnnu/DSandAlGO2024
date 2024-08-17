package DesignPattern.PrototypeDesignPattern;

public class PrototypePatternDemo {
    public static void main(String[] args) {
        // Create initial prototypes
        Goblin originalGoblin = new Goblin("Sword", 100);
        Troll originalTroll = new Troll("Club", 150);

        // Clone the prototypes to create new instances
        Enemy clonedGoblin1 = originalGoblin.clone();
        Enemy clonedGoblin2 = originalGoblin.clone();
        Enemy clonedTroll1 = originalTroll.clone();

        // Use the cloned objects
        clonedGoblin1.attack();  // Output: Goblin attacks with Sword! Health: 100
        clonedGoblin2.defend();  // Output: Goblin defends! Health: 100
        clonedTroll1.attack();   // Output: Troll attacks with Club! Health: 150
    }
}
