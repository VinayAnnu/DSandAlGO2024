package DesignPattern.BuilderDesignPattern;

public class BuilderPatternExample {
    public static void main(String[] args) {
        // Using the Builder to create a House object
        House house = new House.Builder()
                .setRooms(4)
                .setBathrooms(2)
                .setGarage(true)
                .setSwimmingPool(true)
                .setGarden(true)
                .build();

        System.out.println(house);  // Outputs: House with 4 rooms, 2 bathrooms, a garage, a swimming pool, a garden

        // Another house with different configuration
        House smallHouse = new House.Builder()
                .setRooms(2)
                .setBathrooms(1)
                .setGarage(false)
                .setSwimmingPool(false)
                .setGarden(false)
                .build();

        System.out.println(smallHouse);  // Outputs: House with 2 rooms, 1 bathrooms

        // Another house with different configuration
        House verySmallHouse = new House.Builder()
                .setRooms(1)
                .setGarden(true)
                .build();

        System.out.println(verySmallHouse);  // Outputs: House with 1 rooms, 0 bathrooms, a garden
    }
}
