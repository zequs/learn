package com.zequs.demo.se.designpattern.pattern.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherDataSubject extends Subject {
    List<Observer> observers = new ArrayList<>();

    private WeatherData weatherData;

    public WeatherDataSubject(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public void registry(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(weatherData);
        }
    }
}
