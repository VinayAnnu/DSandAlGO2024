package DesignPattern.FactoryDesignPattern;

public class FactoryMethodExample {
    public static void main(String[] args) {
        VehicleFactory carFactory = new CarFactory();
        //carFactory.driveVehicle();
        Vehicle car = carFactory.createVehicle();
        car.drive();  // Outputs: Driving a car!

        VehicleFactory bikeFactory = new BikeFactory();
        //bikeFactory.driveVehicle();
        Vehicle bike = bikeFactory.createVehicle();
        bike.drive();  // Outputs: Riding a bike!
    }
}
