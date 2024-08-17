package DesignPattern.BuilderDesignPattern;

public class House {
    private int rooms;
    private int bathrooms;
    private boolean hasGarage;
    private boolean hasSwimmingPool;
    private boolean hasGarden;

    // Private constructor to enforce the use of Builder
    private House() {}

    // Getters
    public int getRooms() {
        return rooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public boolean hasGarage() {
        return hasGarage;
    }

    public boolean hasSwimmingPool() {
        return hasSwimmingPool;
    }

    @Override
    public String toString() {
        return "House with " + rooms + " rooms, " + bathrooms + " bathrooms, " +
                (hasGarage ? "a garage, " : "") +
                (hasSwimmingPool ? "a swimming pool, " : "") +
                (hasGarden ? "a garden" : "");
    }

    public boolean hasGarden() {
        return hasGarden;
    }

    // Static nested Builder class
    public static class Builder {
        private int rooms;
        private int bathrooms;
        private boolean hasGarage;
        private boolean hasSwimmingPool;
        private boolean hasGarden;

        public Builder setRooms(int rooms) {
            this.rooms = rooms;  //this.rooms refers to static Builder class attributes
            return this;  //this refers to static Builder class object
        }
        public Builder setBathrooms(int bathrooms) {
            this.bathrooms = bathrooms;
            return this;
        }

        public Builder setGarage(boolean hasGarage) {
            this.hasGarage = hasGarage;
            return this;
        }

        public Builder setSwimmingPool(boolean hasSwimmingPool) {
            this.hasSwimmingPool = hasSwimmingPool;
            return this;
        }

        public Builder setGarden(boolean hasGarden) {
            this.hasGarden = hasGarden;
            return this;
        }

        public House build(){
            House house = new House();
            house.rooms = this.rooms;  //house.rooms refers to outer class i.e House class attribute and this.rooms refers to static Builder class attributes
            house.bathrooms = this.bathrooms;
            house.hasGarage = this.hasGarage;
            house.hasSwimmingPool = this.hasSwimmingPool;
            house.hasGarden = this.hasGarden;
            return house;
        }
    }
}
