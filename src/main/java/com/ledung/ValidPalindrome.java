package com.ledung;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        s = sanitizeInput(s);
        var length = s.length();
        var halfLength = length / 2;
        for (int i = 0; i < halfLength; i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    private String sanitizeInput(String s) {
        var result = "";
        for (int i = 0; i < s.length(); i++) {
            var curChar = s.charAt(i);
            if (Character.isDigit(curChar) || Character.isAlphabetic(curChar)) {
                result += Character.toLowerCase(curChar);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        var text = "0P";
        System.out.println(new ValidPalindrome().isPalindrome(text));
    }
}
