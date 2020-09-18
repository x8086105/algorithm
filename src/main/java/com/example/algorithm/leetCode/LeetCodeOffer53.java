package com.example.algorithm.leetCode;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 */
public class LeetCodeOffer53 {

    public static void main(String[] args) {
        int nums[] = {5,7,8,8,8,10};
        int i = search(nums,8);
        System.out.println(i);
    }

    public static int search(int[] nums, int target) {
        int i = helper(nums, target) ;
        int j = helper(nums, target - 1);
        System.out.println("i:" + i + " ----j:" + j);
        return i-j;
    }
    public static int helper(int[] nums, int target){
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        return i;
    }

    public static int binarySearch(int[] nums, int target) {
       return binarySearch(nums,target,0,nums.length -  1);
    }

    private static int binarySearch(int[] nums, int target, int left, int right) {
        if(left > right){
            return -1;
        }else{
            int mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(mid < target){
                return binarySearch(nums,target,mid+1,right);
            }else{
                return binarySearch(nums,target,left,mid-1);
            }
        }

    }
}
