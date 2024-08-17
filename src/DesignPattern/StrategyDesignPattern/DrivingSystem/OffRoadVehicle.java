package DesignPattern.StrategyDesignPattern.DrivingSystem;

import DesignPattern.StrategyDesignPattern.DrivingSystem.Strategy.SportsDriveStrategy;

public class OffRoadVehicle extends Vehicle{
    public OffRoadVehicle(){
        super(new SportsDriveStrategy());
    }
}
