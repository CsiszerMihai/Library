package com.itschool.library.utils.exam_recap;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Joe");
        names.add("Bob");
        names.add("Liam");
        names.add("Samuel");

        for (int index = 0; index < names.size(); index++) {
            System.out.println(names.get(index));
        }
    }
}
