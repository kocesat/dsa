package com.kocesat.datastructure.linear.stack;

import java.util.Stack;

public class StringReverser {
    public String reverse(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
        Stack<Character> charStack = new Stack<>();
        for (char c : input.toCharArray()) {
            charStack.push(c);
        }
        StringBuffer reversed = new StringBuffer();
        while (!charStack.isEmpty()) {
            reversed.append(charStack.pop());
        }
        return reversed.toString();
    }
}
