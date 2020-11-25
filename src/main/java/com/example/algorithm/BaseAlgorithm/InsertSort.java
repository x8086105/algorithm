package com.example.algorithm.BaseAlgorithm;

/**
 * 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] nums = {1,0,5,2,7,2,3};
        sort(nums);
        System.out.println(nums);
    }

    private static void sort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j > 0; j--){
                if(nums[j] < nums[j - 1]){
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
}
