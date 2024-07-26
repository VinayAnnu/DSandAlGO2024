package StrategyDesignPattern.DrivingSystem;

import StrategyDesignPattern.DrivingSystem.Strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle{
    public OffRoadVehicle(){
        super(new SportsDriveStrategy());
    }
}
