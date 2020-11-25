package com.example.algorithm.BaseAlgorithm;

/**
 * 冒泡排序
 * 时间复杂度O(n^2)
 */
public class BubblingSort {

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,2,1,0};
        sort(nums);
        System.out.println(nums);
    }

    private static void sort(int[] nums){
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = nums.length - 1; j > i; j--){
                if(nums[j - 1] > nums[j]){
                    int tmp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }
}
