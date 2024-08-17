package DesignPattern.SingletonDesignPattern;
//Double-Checked Locking mechanism implemented
/*
* Double-checked locking is an optimization technique used to reduce the overhead of acquiring a lock by first checking the
* condition without actually acquiring the lock. Only if the instance is null, we acquire the lock and check again to
* ensure that no other thread has initialized the instance before the current thread acquired the lock.
* */
public class Singleton {
    // Step 1: Private static instance of the class, initially not initialized (null)
    /*The instance is declared as volatile to ensure visibility of changes to variables across threads. This means that when one thread
    updates the value of instance, it is immediately visible to other threads.*/
    private static volatile Singleton instance;

    // Step 2: Private constructor to prevent instantiation from other classes
    private Singleton() {
        // Initialization code
    }

    // Step 3: Public static method to provide a global point of access to the instance
    public static Singleton getInstance() {
        if (instance == null) { // First check (without locking)
            synchronized (Singleton.class) { // Locking
                if (instance == null) { // Second check (with locking)
                    instance = new Singleton(); // Instance is created only once
                }
            }
        }
        return instance;
    }

    // Example method to demonstrate Singleton functionality
    public void doSomething() {
        System.out.println("Singleton instance is working. thread name : "+Thread.currentThread().getName());
    }

}
