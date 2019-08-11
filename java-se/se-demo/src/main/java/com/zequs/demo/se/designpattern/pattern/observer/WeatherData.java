package com.zequs.demo.se.designpattern.pattern.observer;

/**
 * 天气数据对象
 */
public class WeatherData {

    private float templatetrue;

    private float humidity;

    private float pressure;

    public float getTemplatetrue() {
        return templatetrue;
    }

    public void setTemplatetrue(float templatetrue) {
        this.templatetrue = templatetrue;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "templatetrue=" + templatetrue +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                '}';
    }
}
