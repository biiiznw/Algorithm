package com.coding;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an arry of integers, return indices of the two numbers
 * such that they add up to a specific target
 */
public class TwoSum {
    public static void main(String[] args){
        int[] nums = {6, 4, 3, 8, 7, 5, 2};
        TwoSumTest twoSum = new TwoSumTest();
        int[] result = twoSum.test1(nums, 5);
        System.out.println(Arrays.toString(result));
        int[] result1 = twoSum.test2(nums, 5);
        System.out.println(Arrays.toString(result1));
    }
}

class TwoSumTest {
    public int[] test1(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) map.put(nums[i], i);
        for(int n = 0; n < nums.length; n++){
            Integer n1 = map.get(target - nums[n]);
            if(n1 != null && n != n1)
                return new int[]{n,n1};
        }
        throw new IllegalArgumentException("No two sum solution");
    }
    public int[] test2(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
