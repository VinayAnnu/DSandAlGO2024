package DesignPattern.ProxyDesignPattern.CacheProxy;

public class RealDataFetcher implements DataFetcher {
    @Override
    public String fetchData(String resource) {
        // Simulate an expensive operation by adding a delay
        try {
            Thread.sleep(2000); // Simulate delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Data from " + resource;
    }
}
