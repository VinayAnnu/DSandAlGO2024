package DesignPattern.ProxyDesignPattern.CacheProxy;

import java.util.HashMap;
import java.util.Map;

public class CacheProxyDataFetcher implements DataFetcher {
    private RealDataFetcher realDataFetcher = new RealDataFetcher();
    private Map<String, String> cache = new HashMap<>();

    @Override
    public String fetchData(String resource) {
        if (cache.containsKey(resource)) {
            System.out.println("Fetching data from cache for resource: " + resource);
            return cache.get(resource);
        } else {
            System.out.println("Fetching data from remote server for resource: " + resource);
            String data = realDataFetcher.fetchData(resource);
            cache.put(resource, data);
            return data;
        }
    }
}
