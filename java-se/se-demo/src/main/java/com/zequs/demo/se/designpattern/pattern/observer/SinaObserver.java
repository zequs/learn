package com.zequs.demo.se.designpattern.pattern.observer;

public class SinaObserver extends Observer {


    @Override
    public void update(WeatherData weatherData) {
        System.out.println("---sina---");
        super.update(weatherData);
    }
}
