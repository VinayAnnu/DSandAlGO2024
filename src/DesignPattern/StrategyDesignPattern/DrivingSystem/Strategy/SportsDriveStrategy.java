package DesignPattern.StrategyDesignPattern.DrivingSystem.Strategy;

public class SportsDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("It's Sports Drive Strategy");
    }
}
