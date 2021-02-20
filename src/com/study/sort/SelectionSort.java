package com.study.sort;

/**
 * It sorts an array by repeatedly finding the minimum element
 * from the unsorted part and putting it at the beginning.
 * For example, Selecting the first element as the minimum value in the list
 * and compares the next element and minimum value.
 * If the minimum value is greater than the next value,
 * the minimum value is changed while looping in the list.
 * When the minimum value is founded in the list,
 * then swapping the minimum value and the first element value.
 *
 * find min value
 * fix first value which is minimum
 * O(n2)
 */
public class SelectionSort {
    private static void selectionSort(int[] arr){
        selectionSort(arr, 0);
    }
    private static void selectionSort(int[] arr, int start){
        if(start < arr.length-1){
            int min_index = start;
            for(int i = start; i < arr.length; i++){
                if(arr[i] < arr[min_index]) min_index = i;
            }
            swap(arr, start, min_index);
            selectionSort(arr, start + 1);
        }
    }
    private static void swap(int[] arr, int source, int target){
        int tmp = arr[source];
        arr[source] = arr[target];
        arr[target] = tmp;
    }
    private static void printArray(int[] arr){
        for(int data:arr){
            System.out.print(data + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[] arr = {3,6,1,8,2,4};
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
    }
}
