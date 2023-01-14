package com.kocesat.algorithm.sort.impl;

import com.kocesat.algorithm.sort.NumberSorter;
import com.kocesat.algorithm.sort.util.SortUtils;

public class QuickSort implements NumberSorter {
    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int start, int end) {
        if (start >= end)
            return;
        var boundary = partition(arr, start, end);
        // sort left
        quickSort(arr, start, boundary-1);
        // sort right
        quickSort(arr, boundary+1, end);
    }

    private int partition(int[] array, int start, int end) {
        var pivot = array[end];
        var boundary = start - 1; // left partitioned is assumed to be empty
        for (var i = start; i <= end; i++) {
            if (array[i] <= pivot) {
                SortUtils.swap(array, i, ++boundary);
            }
        }
        return boundary;
    }
}
