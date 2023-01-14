package com.kocesat.algorithm.sort.impl;

import com.kocesat.algorithm.sort.NumberSorter;
import com.kocesat.algorithm.sort.util.SortUtils;

public class SelectionSort implements NumberSorter {

    @Override
    public void sort(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
            int minIndex = i;
            for (int j=i+1; j<arr.length; j++) {
                if (arr[j] < arr[i]) {
                    minIndex = j;
                }
            }
            SortUtils.swap(arr, i, minIndex);
        }
    }
}
