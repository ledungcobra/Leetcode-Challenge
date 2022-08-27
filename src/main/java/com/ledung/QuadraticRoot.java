package com.ledung;

import java.util.ArrayList;
import java.util.List;

public class QuadraticRoot {
    private static List<Integer> quadraticRoot(int a, int b, int c) {
        var result = new ArrayList<Integer>();
        var delta = b * b - 4 * a * c;
        if (delta >= 0) {
            result.add((int) ((float) (-b + Math.sqrt(delta)) / 2.0 * a));
            result.add((int) ((float) (-b - Math.sqrt(delta)) / 2.0 * a));
        }
        return result;
    }

    public static void main(String[] args) {
        var solution = quadraticRoot(1, -7, 12);
        System.out.println(solution);
    }
}
