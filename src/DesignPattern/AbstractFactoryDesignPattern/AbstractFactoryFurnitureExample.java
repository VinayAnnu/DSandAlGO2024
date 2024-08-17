package DesignPattern.AbstractFactoryDesignPattern;

public class AbstractFactoryFurnitureExample {
    public static void main(String[] args) {
        FurnitureFactory furnitureFactory;

        // Let's say the customer chooses Modern style
        furnitureFactory = new ModernFurnitureFactory();

        Chair chair = furnitureFactory.createChair();
        Sofa sofa = furnitureFactory.createSofa();

        chair.sitOn(); // Outputs: Sitting on a modern chair.
        sofa.lieOn();  // Outputs: Lying on a modern sofa.

        // If the customer chooses Victorian style
        furnitureFactory = new VictorianFurnitureFactory();

        chair = furnitureFactory.createChair();
        sofa = furnitureFactory.createSofa();

        chair.sitOn(); // Outputs: Sitting on a Victorian chair.
        sofa.lieOn();  // Outputs: Lying on a Victorian sofa.
    }
}
