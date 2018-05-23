package com.xiongzehua.pojo;

import java.util.List;

/**
 * Created by 31339 on 2018/5/11.
 */
public class Person {
    private String name;
    private int age;
    private List<Car> cars;

    public void setAge(int age) {
        this.age = age;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public List<Car> getCars() {
        return cars;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", cars=" + cars +
                '}';
    }
}
