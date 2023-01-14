package com.kocesat.datastructure.linear.stack.impl;

import java.util.Arrays;
import java.util.Objects;

public class Stack {
    private Integer[] numbers;
    private int size = 0;
    private int min = Integer.MAX_VALUE;
    private java.util.Stack<Integer> minStack = new java.util.Stack<>();

    public Stack() {
        this.numbers = new Integer[10];
    }

    public void push(int value) {
        if (isFull()) {
           numbers = Arrays.copyOf(numbers, numbers.length * 2);
        }
        numbers[size++] = value;
        if (value < min) {
            min = value;
            minStack.push(min);
        }
    }

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        int popped = numbers[size - 1];
        numbers[size - 1] = null;
        size--;
        if (popped == min) {
            minStack.pop();
            min = minStack.peek();
        }
        return popped;
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return numbers[size - 1];
    }

    public boolean isFull() {
        return size == numbers.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getMinimum() {
        return min;
    }

    public void print() {
        Arrays.stream(numbers).forEach(n -> {
            if (Objects.nonNull(n)) {
                System.out.println(n);
            }
        });
    }
}
