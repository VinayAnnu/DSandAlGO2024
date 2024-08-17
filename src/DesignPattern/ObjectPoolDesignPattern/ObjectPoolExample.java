package DesignPattern.ObjectPoolDesignPattern;

public class ObjectPoolExample {
    public static void main(String[] args) {
        ConnectionPool pool = ConnectionPool.getInstance();

        // Simulate multiple threads acquiring and releasing connections
        Runnable task = () -> {
            try {
                Connection connection = pool.acquireConnection();
                connection.connect();
                // Simulate some work with the connection
                Thread.sleep(2000);
                connection.disconnect();
                pool.releaseConnection(connection);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };


        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        Thread t3 = new Thread(task);
        Thread t4 = new Thread(task);
        Thread t5 = new Thread(task);
        Thread t6 = new Thread(task);
        Thread t7 = new Thread(task);
        Thread t8 = new Thread(task);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();
    }
}
