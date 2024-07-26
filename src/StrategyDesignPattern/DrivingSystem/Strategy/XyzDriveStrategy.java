package StrategyDesignPattern.DrivingSystem.Strategy;

import StrategyDesignPattern.DrivingSystem.Strategy.DriveStrategy;

public class XyzDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("It's Xyz drive strategy");
    }
}
