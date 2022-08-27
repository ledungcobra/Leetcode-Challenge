package com.ledung;

public class BitAlgorithm {

    private static int firstSetBit(int number) {
        int result = 0;
        while (number != 0) {
            var bit = number & 1;
            if (bit == 1) {
                result <<= 1;
                result |= bit;
            } else if (result != 0) {
                break;
            }
            number >>= 1;
        }
        return result;
    }

    private static int invertSign(int number) {
        return ~number + 1;
    }

    private static int rightMostDifferentBit(int first, int second) {
        int index = 0;
        while (true) {
            var rightFirst = first & 1;
            first >>= 1;
            var rightSecond = second & 1;
            second >>= 1;

            if (rightFirst != rightSecond) {
                break;
            }
            if (rightFirst == 0 || rightSecond == 0) {
                break;
            }
            index++;
        }
        return  index + 1;
    }

    public static void main(String[] args) {
        System.out.println("Right most difference " + rightMostDifferentBit(11, 9));
        System.out.println("Right most difference " + rightMostDifferentBit(52, 4));
    }
}
