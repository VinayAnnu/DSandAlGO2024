package DesignPattern.StrategyDesignPattern.DrivingSystem;

import DesignPattern.StrategyDesignPattern.DrivingSystem.Strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle{
    public GoodsVehicle(){
        super(new NormalDriveStrategy());
    }
}
