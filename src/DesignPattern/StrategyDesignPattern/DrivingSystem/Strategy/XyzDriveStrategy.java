package DesignPattern.StrategyDesignPattern.DrivingSystem.Strategy;

public class XyzDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("It's Xyz drive strategy");
    }
}
