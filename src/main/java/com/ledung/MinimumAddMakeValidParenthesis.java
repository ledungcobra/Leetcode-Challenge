package com.ledung;

import java.util.Stack;

public class MinimumAddMakeValidParenthesis {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.add(c);
            } else {
                if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.add(c);
                }
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {

    }
}
