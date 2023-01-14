package com.kocesat.algorithm.sort.impl;

import com.kocesat.algorithm.sort.NumberSorter;

public class MergeSort implements NumberSorter {

    @Override
    public void sort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        // Divide this array into half
        var middle = arr.length / 2;
        int[] left = divide(arr, 0, middle);
        int[] right = divide(arr, middle, arr.length);
        // Sort each half
        sort(left);
        sort(right);
        // Merge the result
        merge(left, right, arr);
    }

    private void merge(int[] left, int[] right, int[] result) {
        int i=0; // to iterate over left array
        int j=0; // to iterate over right array
        int k=0; // to iterate over result array
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length)
            result[k++] = left[i++];
        while (j < right.length)
            result[k++] = right[j++];
    }

    private int[] divide(int[] arr, int begin, int end) {
        int[] result = new int[end-begin];
        for (int i=begin; i<end; i++) {
            result[i-begin] = arr[i];
        }
        return result;
    }
}
