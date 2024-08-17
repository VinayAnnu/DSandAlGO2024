package DesignPattern.DecoratorDesignPattern.CoffeeShop;

public abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;
    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    public String getDescription() { //currently there is no use of this method.
//        return "";
        return decoratedCoffee.getDescription();
    }
    public double getCost() { //currently there is no use of this method.
//        return 0.1;
        return decoratedCoffee.getCost();
    }
}
