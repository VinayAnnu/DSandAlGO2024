package DesignPattern.DecoratorDesignPattern.CoffeeShop;

public class ChocolateDecorator extends CoffeeDecorator {
    public ChocolateDecorator(Coffee coffee) {
        super(coffee);
    }
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Chocolate";
    }

    public double getCost() {
        return decoratedCoffee.getCost() + 2.0;
    }
}
