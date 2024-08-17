package DesignPattern.PrototypeDesignPattern;

public class Troll implements Enemy {
    private String weapon;
    private int health;

    public Troll(String weapon, int health) {
        this.weapon = weapon;
        this.health = health;
    }

    // Implement the clone method
    @Override
    public Enemy clone() {
        return new Troll(this.weapon, this.health);
    }

    @Override
    public void attack() {
        System.out.println("Troll attacks with " + weapon + "! Health: " + health);
    }

    @Override
    public void defend() {
        System.out.println("Troll defends! Health: " + health);
    }
}