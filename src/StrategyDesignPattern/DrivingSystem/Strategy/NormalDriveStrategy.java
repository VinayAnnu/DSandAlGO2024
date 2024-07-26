package StrategyDesignPattern.DrivingSystem.Strategy;

import StrategyDesignPattern.DrivingSystem.Strategy.DriveStrategy;

public class NormalDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("It's normal drive startegy");
    }
}
