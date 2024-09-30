package com.itschool.library.utils.exam_recap;

public class PalindromeCheck {
    public static void main(String[] args) {
        PalindromeCheck palindromeCheck = new PalindromeCheck();
        String word = "radar";
        boolean isPalindrome = palindromeCheck.palindromeChecker(word);
        System.out.println(isPalindrome);
    }

    public boolean palindromeChecker(String string) {
        String reversed = new StringBuilder(string).reverse().toString();
        return reversed.equals(string);
    }
}
