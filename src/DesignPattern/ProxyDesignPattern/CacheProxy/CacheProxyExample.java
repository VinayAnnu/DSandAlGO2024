package DesignPattern.ProxyDesignPattern.CacheProxy;

public class CacheProxyExample {
    public static void main(String[] args) {
        DataFetcher dataFetcher = new CacheProxyDataFetcher();

        // First fetch will be from the server
        System.out.println(dataFetcher.fetchData("Resource1"));
        System.out.println();

        // Second fetch will be from the cache
        System.out.println(dataFetcher.fetchData("Resource1"));
        System.out.println();

        // Fetching a new resource will be from the server
        System.out.println(dataFetcher.fetchData("Resource2"));
        System.out.println();

        // Again, fetching "Resource1" will be from the cache
        System.out.println(dataFetcher.fetchData("Resource1"));
    }
}
