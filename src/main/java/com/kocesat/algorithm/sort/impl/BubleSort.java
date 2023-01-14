package com.kocesat.algorithm.sort.impl;

import com.kocesat.algorithm.sort.NumberSorter;

import static com.kocesat.algorithm.sort.util.SortUtils.swap;

public class BubleSort implements NumberSorter {

    @Override
    public void sort(int[] arr) {
        boolean sorted = false;
        for (int i=0; i<arr.length && !sorted; i++) {
            sorted = true;
            for (int j=1; j<arr.length-i; j++) {
                if (arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                    sorted = false;
                }
            }
        }
    }
}
