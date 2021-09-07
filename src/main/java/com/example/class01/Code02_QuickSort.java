package com.example.class01;

import com.example.common.AlgorithmUtils;

/**
 * 优化版
 */
public class Code02_QuickSort {

    private static int getPivot(int[] arr, int low, int high) {
        int i = low, j = high, pivot = arr[low];
        while (i < j) {
            while (i < j && arr[j] > pivot) {
                j--;
            }
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            if (i < j) {
                AlgorithmUtils.swap(arr, i, j);
            }
        }
        if (arr[i] > pivot) {
            AlgorithmUtils.swap(arr, arr[i - 1], arr[low]);
            return i - 1;
        }
        AlgorithmUtils.swap(arr, arr[i], arr[low]);
        return i;
    }
}
