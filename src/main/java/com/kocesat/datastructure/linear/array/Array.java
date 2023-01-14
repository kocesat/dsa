package com.kocesat.datastructure.linear.array;

import java.util.ArrayList;
import java.util.List;

public class Array {
    private int[] items;
    private int count = 0;
    private int nextAvailableIndex = 0;

    public Array(int initialSize) {
        this.items = new int[initialSize];
    }

    public void insert(int number) {
        if (isFull()) {
            this.doubleTheSize();
        }
        items[count++] = number;
    }

    public void insertAt(int number, int index) {
        if (index < 0 || index > count) {
            throw new IllegalArgumentException();
        }
        if (isFull()) {
            this.doubleTheSize();
        }
        for (int j = count - 1; j >= index; j--) {
            items[j+1] = items[j];
        }
        items[index] =  number;
        count++;
    }

    public void removeAt(int index) {
        validateIndex(index);
        int[] newItems = new int[items.length];
        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }
        count--;
    }

    public int indexOf(int number) {
        // better to use binary search
        for (int i = 0; i < count; i++) {
            if (number == items[i]) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    /**
     * Complexity: O(n)
     */
    public int max() {
        if (count == 0) {
            throw new IllegalStateException("Array is empty");
        }
        int maximum = items[0];
        for (int item : items) {
            if (item > maximum) {
                maximum = item;
            }
        }
        return maximum;
    }

    /**
     * Complexity: O(n^2)
     */
    public List<Integer> intersect(int[] otherArr) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < otherArr.length; j++) {
                if (items[i] == otherArr[j]) {
                    result.add(items[i]);
                }
            }
        }
        return result;
    }

    public void reverse() {
        int[] newItems = new int[items.length];
        int counter = 0;
        for (int lastIndex = count - 1; lastIndex >= 0; lastIndex--) {
            newItems[counter++] = items[lastIndex];
        }
        this.items = newItems;
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Index is not valid");
        }
    }

    private boolean isFull() {
        return count == items.length;
    }

    private void doubleTheSize() {
        int[] tempArray = new int[2 * count];
        for (int i = 0; i < count; i++) {
            tempArray[i] = items[i];
        }
        this.items = tempArray;
    }
}
