package com.ledung;

public class ToLowerCase {
    public String toLowerCase(String s) {
        var result = "";
        for (int i = 0; i < s.length(); i++) {
            var curChar = s.charAt(i);
            if (curChar >= 'A' && curChar <= 'Z') {
                curChar += 'a' - 'A';
            }
            result += curChar;
        }
        return result;
    }
}
