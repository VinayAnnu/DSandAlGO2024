package StrategyDesignPattern.DrivingSystem.Strategy;

import StrategyDesignPattern.DrivingSystem.Strategy.DriveStrategy;

public class SportsDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("It's Sports Drive Strategy");
    }
}
