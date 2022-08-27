package com.ledung;

public class ReverseInteger {
    public int reverse(int x) {
        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = -x;
        }
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        if (isNegative) {
            return (int) -result;
        }
        return (int) result;
    }

    private int getNumberDigit(int x) {
        return (int) (Math.log10(x) + 1);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(1));
        System.out.println(new ReverseInteger().reverse(-123));
    }
}
