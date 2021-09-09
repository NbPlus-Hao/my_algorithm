package com.example.class02;


import com.example.common.AlgorithmUtils;

public class Code3_HeapSort {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 8, 6, 2, 0};
        heapSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void heapSort(int[] arr) {
        //1、构建大顶堆 O(N*LogN)
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr, i);
//        }
        // O(N)
        for (int i = arr.length - 1; i >= 0; i--) {
            heapIfy(arr, i, arr.length);
        }
        int heapSize = arr.length;
        AlgorithmUtils.swap(arr, 0, --heapSize);
        while (heapSize > 0) {
            heapIfy(arr, 0, heapSize);
            AlgorithmUtils.swap(arr, 0, --heapSize);
        }
    }

    private static void heapInsert(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            AlgorithmUtils.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private static void heapIfy(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (index == largest) {
                break;
            }
            AlgorithmUtils.swap(arr, index, largest);
            index = largest;
            left = index * 2 + 1;
        }
    }

}
