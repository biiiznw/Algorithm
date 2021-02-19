package com.company.sort;

/**
 * select random value in Array
 * Array : ㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁㅁ
 *                |selected 5th
 *         smaller  bigger
 *         O(n log n)
 *  ------------------------------------------------------------------------
 *  Worst case : O(n2)
 *  3, 9, 4, 7, 0, 1, 5, 8, 6, 2
 *  select pivot 0
 *        0, 3, 9, 4, 7, 1, 5, 8, 6, 2
 *  smaller| bigger
 *  select pivot = 1
 *        0, 1, 3, 9, 4, 7, 5, 8, 6, 2
 *    smaller | bigger
 *  smaller| bigger
 *  if selected pivot is the smallest or biggest, O(n2) which is the worst case.
 *  ------------------------------------------------------------------------
 *  select pivot = 5
 *       startPoint   3, 9, 4, 7, 5, 0, 1, 6, 8, 2  endPoint
 *  startPoint will ignore it if the value is smaller than pivot
 *  endPoint will ignore it if the value is greater than pivot
 *  start point stops at 1st point(value: 9)
 *  end point stops at 9th point(value: 2)
 *          3, 9, 4, 7, 5, 0, 1, 6, 8, 2
 *                  ----- Swap ----
 *          3, 2, 4, 7, 5, 0, 1, 6, 8, 9
 *  start point stops at 3rd point(value: 7)
 *  end point stops at 6th point(value: 1)
 *          3, 2, 4, 7, 5, 0, 1, 6, 8, 9
 *                  ----- Swap ----
 *          3, 2, 4, 1, 5, 0, 7, 6, 8, 9
 *                  ----- Swap ----
 *          3, 2, 4, 1, 0, 5, 7, 6, 8, 9 : result
 *                  ---- END LOOP ----
 *          smaller        |   greater than 5 (pivot)
 *
 *                      QuickSort(0,9)
 *                      /             \
 *             QuickSort(0,4)       QuickSort(5,9)
 *             /                    /           \
 *  QuickSort(0,3)           QuickSort(5,6) QuickSort(7,9)
 *          /       \                           /
 *  QuickSort(0,1)  QuickSort(2,3)      QuickSort(7,8)
 *
 */
public class QuickSort {
    private static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }
    private static void quickSort(int[] arr, int start, int end){
        int part2 = partition(arr, start, end);
        if(start < part2 -1){
            quickSort(arr, start, part2-1);
        }
        if(part2 < end) {
            quickSort(arr, part2, end);
        }
    }
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
        while (start <= end){
            while (arr[start] < pivot) start ++;
            while (arr[end] > pivot) end --;
            if(start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }
    private static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }
    private static void printArray(int[] arr){
        for(int data : arr){
            System.out.print(data + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
        printArray(arr);
        quickSort(arr);
        printArray(arr);
    }
}
