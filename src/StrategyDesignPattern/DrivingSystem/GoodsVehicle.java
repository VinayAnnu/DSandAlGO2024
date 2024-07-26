package StrategyDesignPattern.DrivingSystem;

import StrategyDesignPattern.DrivingSystem.Strategy.NormalDriveStrategy;

public class GoodsVehicle extends Vehicle{
    public GoodsVehicle(){
        super(new NormalDriveStrategy());
    }
}
