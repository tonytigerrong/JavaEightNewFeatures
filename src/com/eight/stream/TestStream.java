package com.eight.stream;


import jdk.nashorn.internal.runtime.options.Option;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestStream {
    public static void main(String[] args) {
        Car car11 = new Car("Honda", 10000);
        Car car21 = new Car("Toyota", 11000);
        Car car31 = new Car("BMW", 12000);
        Car car41 = new Car("Benz", 13000);
        Car car51 = new Car("Mazeda", 14000);
        List<Car> cars = new ArrayList<Car>();
        cars.add(car11);
        cars.add(car21);
        cars.add(car31);
        cars.add(car41);
        cars.add(car51);

        Car car = cars.stream().reduce(car11, (car1, car2) -> {
            return car1.getPrice() > car2.getPrice() ? car1 : car2;
        });
        System.out.println(car.toString());

        Predicate<Car> predicate = car12 -> car12.getPrice() > 10000;
        cars.stream().filter(predicate).forEach(System.out::println);

        List<Tool> tools = cars.stream().map(car5 -> {
            return new Tool("car", car5.getPrice());
        }).collect(Collectors.toList());
        tools.stream().forEach(System.out::println);


        Collections.replaceAll(cars, car11, car21);
        cars.stream().forEach(System.out::println);

        ConcurrentHashMap<String, Car> concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("id1", car11);
        concurrentHashMap.put("id2", car21);
        concurrentHashMap.put("id3", car31);
        concurrentHashMap.put("id4", car41);
        concurrentHashMap.put("id5", car51);
        concurrentHashMap.forEachKey(2, (key) -> {
            System.out.println(concurrentHashMap.get(key));
            concurrentHashMap.compute(key, (k, v) -> {
                return car11;
            });
        });
//        concurrentHashMap.compute("id2", (key1, value1)->{
//            value1 = car11;
//            return value1;
//        });
        concurrentHashMap.forEach((key, value) -> {
            System.out.println(value);
        });

        Car v1 = concurrentHashMap.search(2, (k, v) -> {
            return k.equals("id3") ? v : null;
        });
        System.out.println("found:" + v1);

    }


}


