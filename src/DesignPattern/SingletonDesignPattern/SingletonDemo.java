package DesignPattern.SingletonDesignPattern;

public class SingletonDemo {
    public static void main(String[] args) {
        // Multiple threads trying to access the singleton instance
        Thread thread1 = new Thread(() -> {
            Singleton singleton = Singleton.getInstance();
            singleton.doSomething();
        });

        Thread thread2 = new Thread(() -> {
            Singleton singleton = Singleton.getInstance();
            singleton.doSomething();
        });

        thread1.setName("THREAD-1");
        thread2.setName("THREAD-2");
        thread1.start();
        thread2.start();


    }
}
