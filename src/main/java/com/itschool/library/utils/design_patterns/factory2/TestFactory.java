package com.itschool.library.utils.design_patterns.factory2;

public class TestFactory {

    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();

        Car suv = carFactory.assembleCar("suv");
        suv.assemble();

        Car sedan = carFactory.assembleCar("sedan");
        sedan.assemble();

        Car hatchback = carFactory.assembleCar("hatchback");
        hatchback.assemble();
    }
}