package com.itschool.library.utils.exam_recap;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String to reverse");
        String input = new StringBuilder(sc.nextLine()).reverse().toString();
        sc.close();
        System.out.println(input);
    }
}