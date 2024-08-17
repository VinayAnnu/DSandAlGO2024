package DesignPattern.DecoratorDesignPattern.CoffeeShop;

public class SimpleCoffee implements Coffee {

    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public double getCost() {
        return 5.9;
    }
}
