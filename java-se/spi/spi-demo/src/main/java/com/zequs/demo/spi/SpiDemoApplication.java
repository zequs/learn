package com.zequs.demo.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

import com.zequs.demo.spi.server.People;

public class SpiDemoApplication {

    public static void main(String[] args) {
        //		SpringApplication.run(SpiDemoApplication.class, args);
        ServiceLoader<People> peoples = ServiceLoader.load(People.class);
        Iterator<People> iterator = peoples.iterator();
        while (iterator.hasNext()) {
            People people = iterator.next();
            people.say();
        }
    }

}
