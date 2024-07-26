package StrategyDesignPattern.DrivingSystem;

import StrategyDesignPattern.DrivingSystem.Strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle{
    public SportsVehicle() {
        super(new SportsDriveStrategy());
    }
}
