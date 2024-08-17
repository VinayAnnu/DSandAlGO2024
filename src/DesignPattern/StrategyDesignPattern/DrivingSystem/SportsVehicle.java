package DesignPattern.StrategyDesignPattern.DrivingSystem;

import DesignPattern.StrategyDesignPattern.DrivingSystem.Strategy.SportsDriveStrategy;

public class SportsVehicle extends Vehicle{
    public SportsVehicle() {
        super(new SportsDriveStrategy());
    }
}
