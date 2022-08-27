package com.ledung;

public class Factorial {

    static long factorial(int number) {
        var result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }


    public static void main(String[] args) {
        int test = 5;
        System.out.println("Factorial of " + test + " = " + factorial(test));
    }
}
