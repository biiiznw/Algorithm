package com.study.sort;

/**
 * MergeSort
 * 함수가 호출될때마다 절반씩 잘라서 재귀적으로 함수를 호출하고 맨 끝에 제일 작은 조각부터
 * 2개씩 병합해서 정렬된 배열을 머지해 나가는 방식
 * This algorithm is based on splitting a list, into two comparable sized lists.
 * When the function is called, it divides N elements in half and recurs function.
 * The method merges arranged elements by merging two pieces from the smallest piece in the last.
 * left and right and then sorting each list and then merging the two sorted lists back together as one.
 * It is O(n log n) that is always the same. But it needs to have extra storage space.
 *
 * unsorted array
 * 4,2,6,3,7,8,5,1
 *  ㅁㅁㅁㅁㅁㅁㅁㅁ
 *  ㅁㅁㅁㅁ    ㅁㅁㅁㅁ
 *  ㅁㅁ ㅁㅁ   ㅁㅁ ㅁㅁ
 *  4,2 6,3  7,8 5,1
 *  2,4 vs 3,6  7,8 vs 1,5
 *  marge
 *  2,3,4,5     1,5,7,8
 *  marge
 *  1,2,3,4,5,6,7,8
 *  함수가 호출될때마다 절반씩 잘라서 재귀적으로 함수를 호출하고
 *  맨 끝 제일 작은 조각부터 두개씩 병합해서 정렬된 배열을 머지해나가는 방법
 *
 *  --------------- N -------------------
 *  |           ㅁㅁㅁㅁㅁㅁㅁㅁ
 *  |       ㅁㅁㅁㅁ        ㅁㅁㅁㅁ
 *  |    ㅁㅁ    ㅁㅁ     ㅁㅁ    ㅁㅁ
 *  logN
 *   O(n log n)
 *  * 임시 저장소가 필요
 */
public class MergeSort {
    private static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length-1);
    }
    private static void mergeSort(int[] arr, int[] tmp, int start, int end){
        if(start < end){
            int mid = (start + end) / 2;
            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid + 1, end);
            merge(arr, tmp, start, mid, end);
        }
    }
    private static void merge(int[] arr, int[] tmp, int start, int mid, int end){
        for(int i = start; i <= end; i++){
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;
        while(part1 <= mid && part2 <=end){
            if(tmp[part1] <= tmp[part2]){
                arr[index] = tmp[part1];
                part1++;
            }else{
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        for(int i = 0; i <= mid - part1; i++){
            arr[index + i] = tmp[part1 + i];
        }
    }
    private static void printArray(int[] arr){
        for(int data:arr){
            System.out.print(data + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
        printArray(arr);
        mergeSort(arr);
        printArray(arr);
    }
}
