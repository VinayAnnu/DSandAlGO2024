package DesignPattern.ObserverDesignPattern.WeatherMonitoringSystem;

public interface WeatherSubject {
    void registerObserver(WeatherObserver observer);
    void removeObserver(WeatherObserver observer);
    void notifyObservers();
}