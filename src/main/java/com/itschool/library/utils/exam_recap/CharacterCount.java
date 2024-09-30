package com.itschool.library.utils.exam_recap;

public class CharacterCount {

    public static void main(String[] args) {
        String input = "abracadabra";
        char character = 'a';

        int count = 0;
        for(char chars : input.toCharArray()) {
            if(chars == character) {
                count++;
            }
        }
        System.out.println("Number of letter occurrences: " + count);
    }
}