package com.itschool.library.utils.exam_recap;

public class Vehicle {
    public void move() {
        System.out.println("Vehicle is moving");
    }
}

class Bike extends Vehicle {
    @Override
    public void move() {
        System.out.println("Bike is moving");
    }
}

class Car extends Vehicle{
    @Override
    public void move() {
        System.out.println("Car is moving");
    }
}

class MainTestVehicle {
    public static void main(String[] args) {
        Vehicle bike = new Bike();
        Vehicle car = new Car();

        bike.move();
        car.move();
    }
}
