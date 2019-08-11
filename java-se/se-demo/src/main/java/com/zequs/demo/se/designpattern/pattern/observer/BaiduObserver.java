package com.zequs.demo.se.designpattern.pattern.observer;

public class BaiduObserver extends Observer {
    @Override
    public void update(WeatherData weatherData) {
        System.out.println("---baidu---");
        super.update(weatherData);
    }
}
