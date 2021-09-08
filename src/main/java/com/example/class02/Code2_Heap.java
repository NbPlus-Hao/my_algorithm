package com.example.class02;

import com.example.common.AlgorithmUtils;

public class Code2_Heap {
    public static void main(String[] args) {

    }


    // 新加的数先停在index位置，然后依次和父节点比较。当比父节点小或者移动到根节点停止。
    public static void insertHeap(int[] arr, int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            AlgorithmUtils.swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    // 从index往下看不断的下沉，当大于左右两子节点停
    public static void heapIfy(int[] arr, int index, int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index) {
                break;
            }
            AlgorithmUtils.swap(arr, largest, index);
            index = largest;
            left = index * 2 + 1;
        }
    }
}
