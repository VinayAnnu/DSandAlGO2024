package DesignPattern.ObserverDesignPattern.WeatherMonitoringSystem;

public class WeatherStation {
    public static void main(String[] args) {
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();

        WeatherData weatherData = new WeatherData();

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(forecastDisplay);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
    }
}
