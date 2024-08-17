package DesignPattern.StrategyDesignPattern.DrivingSystem.Strategy;

public class NormalDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("It's normal drive startegy");
    }
}
