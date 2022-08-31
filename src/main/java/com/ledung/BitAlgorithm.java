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
        return index + 1;
    }

    public static int getNthBit(int number, int i) {
        return number >> i & 1;
    }

    public static int getNBitUsingMask(int number, int i) {
        int mask = 1 << i;
        return (number & mask) > 0 ? 1 : 0;
    }

    public static int clearBit(int number, int i) {
        int mask = ~(1 << i);
        return number & mask;
    }

    public static int setBit(int number, int i) {
        int mask = 1 << i;
        return number | mask;
    }

    public static int updateIthBit(int number, int i, int v) {
        int result = clearBit(number, i);
        int mask = (v << i);
        return result | mask;
    }

    public static int clearLastIBit(int number, int i) {
        int result = number;
        for (int r = 0; r < i; r++) {
            result &= ~(1 << r);
        }
        return result;
    }

    public static int clearLastBitV2(int number, int i) {
        int mask = ~0 << i;
        return number & mask;
    }

    public static int clearRangeBit(int number, int i, int j) {
        int mask1 = -1 << j + 1;
        int mask2 = 1 << i - 1;
        int mask = mask1 | mask2;
        return number & mask;
    }

    public static int replaceBits(int original, int replacement, int start, int end) {
        original = clearRangeBit(original, start, end);
        int countBit = end - start + 1;
        replacement &= ~(-1 << countBit);
        replacement <<= start;
        return original | replacement;
    }

    public static void main(String[] args) {
        int original = 1111;
        int replacement = 12;
        System.out.println(Integer.toBinaryString(original));
        System.out.println(Integer.toBinaryString(replacement));
        System.out.println(Integer.toBinaryString(replaceBits(original,replacement,1,3)));
    }
}
