package com.kocesat.datastructure.linear.stack;

import java.util.List;
import java.util.Stack;

public class Expression {
    private String input;
    private Stack<Character> stack = new Stack<>();
    private static final List<Character> LEFT_BRACKETS = List.of('(', '[', '{', '<');
    private static final List<Character> RIGHT_BRACKETS = List.of(')', ']', '}', '>');

    public Expression(String input) {
        this.input = input;
    }

    public boolean isBalanced() {
        if (input == null) {
            return true;
        }

        for (char ch : input.toCharArray()) {
            if (isLeftBracket(ch)){
                stack.push(ch);
            }
            if (isRightBracket(ch)) {
                if (stack.empty()) {
                    return false;
                }
                var left = stack.pop();
                if (!bracketsMatch(left, ch)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    private boolean isLeftBracket(char ch) {
        return LEFT_BRACKETS.contains(ch);
    }

    private boolean isRightBracket(char ch) {
        return RIGHT_BRACKETS.contains(ch);
    }

    private boolean bracketsMatch(char left, char right) {
        return LEFT_BRACKETS.indexOf(left) == RIGHT_BRACKETS.indexOf(right);
    }
}
