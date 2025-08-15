package DesignPattern.ProxyDesignPattern.SmartProxy;

public class SmartProxy implements ExpensiveObject {
    private static RealExpensiveObject realObject;
    private static int referenceCount = 0;
    public SmartProxy() {
        if (realObject == null) {
            realObject = new RealExpensiveObject();
        }
        referenceCount++;
        System.out.println("Reference count increased: " + referenceCount);
    }
    @Override
    public void process() {
        if (realObject != null) {
            realObject.process();
        }
    }

    public void release() {
        referenceCount--;
        System.out.println("Reference count decreased: " + referenceCount);
        if (referenceCount == 0) {
            realObject = null; // Dereference the real object
            System.out.println("RealExpensiveObject is dereferenced and can be garbage collected.");
        }
    }
}
