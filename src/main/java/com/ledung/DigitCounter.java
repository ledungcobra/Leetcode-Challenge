package com.ledung;

public class DigitCounter {
    protected static int countDigit(long x) {
        if (x < 0) {
            x = -x;
        }
        var count = 0;
        do {
            x /= 10;
            count++;
        } while (x != 0);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countDigit(-1999));
    }
}
