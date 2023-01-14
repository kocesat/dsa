package com.kocesat.algorithm.sort.impl;

import com.kocesat.algorithm.sort.NumberSorter;

public class InsertionSort implements NumberSorter {

    @Override
    public void sort(int[] arr) {
        for (int i=1; i<arr.length; i++) {
            int current = arr[i];
            for (int j=i-1; j>=0; j--) {
                if (arr[j] > current) {
                    arr[j+1] = arr[j];
                } else {
                    arr[j+1] = current;
                    break;
                }
            }
        }
    }
}
