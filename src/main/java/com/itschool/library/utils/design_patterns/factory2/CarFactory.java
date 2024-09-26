package com.itschool.library.utils.design_patterns.factory2;

public class CarFactory {

    public Car assembleCar(String carType) {
        if (carType.equalsIgnoreCase("suv")) {
            return new SUV();
        } else if (carType.equalsIgnoreCase("sedan")) {
            return new Sedan();
        } else if (carType.equalsIgnoreCase("hatchback")) {
            return new Hatchback();
        } else {
            throw new IllegalArgumentException("Invalid car type " + carType);
        }
    }
}