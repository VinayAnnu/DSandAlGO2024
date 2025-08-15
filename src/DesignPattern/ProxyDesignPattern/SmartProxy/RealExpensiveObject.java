package DesignPattern.ProxyDesignPattern.SmartProxy;

public class RealExpensiveObject implements ExpensiveObject {
    public RealExpensiveObject() {
        initialize();
    }

    private void initialize() {
        System.out.println("Performing expensive initialization...");
        // Simulate an expensive operation
        try {
            Thread.sleep(2000); // Simulate a delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void process() {
        System.out.println("Processing complete.");
    }
}
