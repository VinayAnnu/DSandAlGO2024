package DesignPattern.ProxyDesignPattern.SmartProxy;

public class SmartProxyExample {
    public static void main(String[] args) {
        ExpensiveObject obj1 = new SmartProxy();
        obj1.process();

        ExpensiveObject obj2 = new SmartProxy();
        obj2.process();

        // Release the first reference
        ((SmartProxy) obj1).release();

        // Release the second reference, should trigger cleanup
        ((SmartProxy) obj2).release();

    }
}
