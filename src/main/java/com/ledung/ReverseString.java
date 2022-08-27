package com.ledung;

public class ReverseString {
    public void reverseString(char[] s) {
        int mid = s.length / 2;
        for (int i = 0; i < mid; i++) {
            var tmp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = tmp;
        }
    }
}
