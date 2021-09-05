package com.example.class01;

import com.example.common.AlgorithmUtils;

public class Code01_QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 划分
            int pivotIndex = getPivotIndex(arr, low, high);
            // 左区间递归快速排序
            quickSort(arr, low, pivotIndex);
            // 右区间递归快速排序
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int getPivotIndex(int[] arr, int low, int high) {
        int i = low, j = high, pivot = arr[low];
        while (i < j) {
            // 从右向左扫描
            while (i < j && pivot < arr[j]) {
                j--;
            }
            if (i < j) {
                // 在r[i]和r[j]交换后，i+1，右移一位
                AlgorithmUtils.swap(arr, i++, j);
            }
            // 从左向右扫描
            while (i < j && pivot >= arr[i]) {
                i++;
            }
            if (i < j) {
                // 在r[i]和r[j]交换后，j-1，左移一位
                AlgorithmUtils.swap(arr, i, j--);
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = {12, 36, 24, 42, 5, 39, 58, 18};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
