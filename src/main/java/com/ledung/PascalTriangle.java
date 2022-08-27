package com.ledung;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 1) {
            var l = new ArrayList<List<Integer>>();
            var l2 = new ArrayList<Integer>();
            l.add(l2);
            l2.add(1);
            return l;
        } else if (numRows == 2) {
            var l = new ArrayList<List<Integer>>();
            var l2 = new ArrayList<Integer>();
            l.add(l2);
            l2.add(1);
            var l3 = new ArrayList<Integer>();
            l3.add(1);
            l3.add(1);
            l.add(l3);
            return l;
        }
        var curGenerated = generate(numRows - 1);
        var prev = curGenerated.get(curGenerated.size() - 1);
        var list = new ArrayList<>(prev);

        list.add(1);
        curGenerated.add(list);
        for (int i = 1; i <=list.size() - 2; i++) {
            list.set(i, prev.get(i - 1) + prev.get(i));
        }
        return curGenerated;
    }

    public static void main(String[] args) {
        System.out.println(new PascalTriangle().generate(5));
    }
}
