package org.example;

public class WeatherService {
    private final WeatherApi weatherApi;

    public WeatherService(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    public String fetchWeather() {
        return weatherApi.getCurrentTemperature();
    }
}

