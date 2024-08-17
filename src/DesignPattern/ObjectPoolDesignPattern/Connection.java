package DesignPattern.ObjectPoolDesignPattern;

public class Connection {
    private String connectionString;

    public Connection(String connectionString) {
        this.connectionString = connectionString;
        // Simulate expensive connection creation process like--> Connection conn = DriverMangaer.getConnection(url,user,pass);
        System.out.println("Connection created: " + connectionString);
    }

    public void connect() {
        System.out.println("Connected to: " + connectionString);
    }

    public void disconnect() {
        System.out.println("Disconnected from: " + connectionString);
    }

}
