package com.kocesat.algorithm.sort;

import com.kocesat.algorithm.sort.impl.QuickSort;

import java.util.Arrays;

public class SortDemo {
    public static void main(String[] args) {
        int[] arr = {-1, 2, -20, 7, 7, 2, 100, 24};
        NumberSorter sorter = new QuickSort();
        sorter.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
