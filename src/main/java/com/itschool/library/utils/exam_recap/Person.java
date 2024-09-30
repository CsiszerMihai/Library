package com.itschool.library.utils.exam_recap;

public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class PersonTest {

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(24);
        person.setName("Alice");

        System.out.println(person.getAge());
        System.out.println(person.getName());
    }
}