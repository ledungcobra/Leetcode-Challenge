package com.ledung;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int numberDigit = getNumberDigit(x);
        while (x != 0 && numberDigit > 0) {
            var lastDigit = x % 10;
            var curNoDigit = getNumberDigit(x);
            int firstDigit = 0;
            if (curNoDigit == numberDigit) {
                firstDigit = x / (int) Math.pow(10, curNoDigit - 1);
            }
            if (lastDigit != firstDigit) {
                return false;
            }
            x -= lastDigit;
            x -= firstDigit * (int) Math.pow(10, curNoDigit - 1);
            x /= 10;
            numberDigit -= 2;

        }
        return true;
    }

    private int getNumberDigit(int x) {
        return (int) (Math.log10(x) + 1);
    }

    public static void main(String[] args) {
        System.out.println(new PalindromeNumber().isPalindrome(1000021));
        System.out.println(new PalindromeNumber().isPalindrome(1000110001));
        System.out.println(new PalindromeNumber().isPalindrome(121));
    }
}
