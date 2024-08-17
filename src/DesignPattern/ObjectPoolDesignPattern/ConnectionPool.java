package DesignPattern.ObjectPoolDesignPattern;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConnectionPool {
    private static volatile ConnectionPool instance;

    /*The pool is implemented using BlockingQueue (specifically LinkedBlockingQueue), which is a thread-safe collection that allows threads to
     wait for elements to become available or for space to become available in the queue.
     they wait if no connections are available and acquire a connection as soon as one is released back into the pool.
     */
    private BlockingQueue<Connection> pool;
    private final int MAX_POOL_SIZE = 5;

    // Step 1: Private constructor to prevent instantiation
    private ConnectionPool() {
        pool = new LinkedBlockingQueue<>(MAX_POOL_SIZE);
        // Initialize the pool with some connections
        for (int i = 0; i < MAX_POOL_SIZE; i++) {
            pool.add(new Connection("DatabaseConnection-" + (i + 1)));
        }
    }

    // Step 2: Public method to get the Singleton instance of the ConnectionPool
    public static ConnectionPool getInstance() {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                }
            }
        }
        return instance;
    }

    // Step 3: Method to acquire a connection from the pool
    public Connection acquireConnection() throws InterruptedException {
        return pool.take();
    }

    // Step 4: Method to release a connection back to the pool
    public void releaseConnection(Connection connection) {
        if (connection != null) {
            pool.offer(connection);
        }
    }
}
