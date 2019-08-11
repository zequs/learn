package com.zequs.demo.se.designpattern.pattern.observer;


/**
 * 观察者
 */
public abstract class Observer {
    public  void update(WeatherData weatherData) {
        System.out.println(weatherData);
    }
}
