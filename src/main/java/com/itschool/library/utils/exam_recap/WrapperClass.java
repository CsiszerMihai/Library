package com.itschool.library.utils.exam_recap;

public class WrapperClass {

    public static void main(String[] args) {
        Integer number = 2;
        String numberToString = number.toString();
        System.out.println("int to str: " + numberToString);

        String str = "200";
        Integer stringToNumber = Integer.parseInt(str);
        System.out.println("str to int: " + stringToNumber);
    }
}
