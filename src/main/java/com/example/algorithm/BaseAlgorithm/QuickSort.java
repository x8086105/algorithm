package com.example.algorithm.BaseAlgorithm;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,2,1,0};
        sort(nums,0,nums.length - 1);
        System.out.println(nums);
    }

    /**
     * 选定一个哨兵 ，一般选中间那个作为哨兵
     * @param nums
     */
    private static void sort(int[] nums,int low,int high){
        if(low > high){
            return;
        }
        int sentry = nums[low];
        int i = low;
        int j = high;
        while (i != j){
            while (nums[j] >= sentry && i < j){
                j--;
            }
            while (nums[i] <= sentry && i < j){
                i++;
            }
            if(i < j){
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        nums[low] = nums[i];
        nums[i] = sentry;
        sort(nums, low, i - 1);
        sort(nums, i + 1, high);

    }

}
