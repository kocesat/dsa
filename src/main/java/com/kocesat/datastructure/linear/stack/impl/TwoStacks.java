package com.kocesat.datastructure.linear.stack.impl;

import java.util.Arrays;

public class TwoStacks {
    private int[] arr = new int[10];
    private int counter1 = 0;
    private int counter2 = 10;

    public int pop1() {
        checkArrayLengthForPop(true);
        return arr[--counter1];
    }

    public int pop2() {
        checkArrayLengthForPop(false);
        return arr[counter2++];
    }

    public void push1(int value) {
        checkArrayLengthForPush();
        arr[counter1++] = value;
    }

    public void push2(int value) {
        // [0, 0, 2]
        // counter2 = 2
        // push2(2);
        // pop();
        checkArrayLengthForPush();
        arr[--counter2] = value;
    }

    private void checkArrayLengthForPush() {
        if (counter1 == counter2) {
            throw new StackOverflowError();
        }
    }

    private void checkArrayLengthForPop(boolean first) {
        if ((first && counter1 == 0) || (!first && counter2 == 10) ) {
            throw new IllegalStateException("Empty stack");
        }
    }

    public boolean isEmpty() {
        return counter1 == 0 && counter2 == 10;
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}
