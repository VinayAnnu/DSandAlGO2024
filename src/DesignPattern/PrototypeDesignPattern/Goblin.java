package DesignPattern.PrototypeDesignPattern;

public class Goblin implements Enemy {
    private String weapon;
    private int health;

    public Goblin(String weapon, int health) {
        this.weapon = weapon;
        this.health = health;
    }

    @Override
    public Enemy clone() {
        return new Goblin(this.weapon, this.health);
    }

    @Override
    public void attack() {
        System.out.println("Goblin attacks with " + weapon + "! Health: " + health);
    }

    @Override
    public void defend() {
        System.out.println("Goblin defends! Health: " + health);
    }
}
