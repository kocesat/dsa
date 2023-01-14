package com.kocesat.algorithm.sort.util;

public final class SortUtils {

    public SortUtils() {
        throw new IllegalStateException("utility class");
    }

    public static void swap(int[] arr, int i, int j) {
        System.out.println("swapping " + arr[i] + " with " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
