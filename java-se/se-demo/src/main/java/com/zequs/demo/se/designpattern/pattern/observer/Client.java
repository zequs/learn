package com.zequs.demo.se.designpattern.pattern.observer;

/**
 * 观察者模式：天气预报，气象站中天气信息一更改，每个接收者的数据都需要更新
 * 气象站（一的一方）：Subject
 * 观察者（多的一方）：Observer
 */
public class Client {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        weatherData.setTemplatetrue(28.2f);
        weatherData.setHumidity(52f);
        weatherData.setPressure(1.12f);

        Observer baiduObserver = new BaiduObserver();
        Observer sinaObserver = new SinaObserver();
        Subject subject = new WeatherDataSubject(weatherData);
        subject.registry(baiduObserver);
        subject.registry(sinaObserver);
        subject.notifyObserver();
    }
}
