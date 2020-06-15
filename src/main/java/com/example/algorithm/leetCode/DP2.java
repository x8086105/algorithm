package com.example.algorithm.leetCode;

public class DP2 {
    public static void main(String[] args) {
        int []nums = {-2,1,-3,4,-1,2,1,-5,4};
        int max = maxSubArray(nums);
        System.out.println(max);
    }
    public static int maxSubArray(int[] nums) {
        int [] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i<nums.length;i++){
            dp[i] = Math.max(nums[i],nums[i]+dp[i-1]);
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length;i++){
            res =  Math.max(res,dp[i]);
        }
        return res;
    }
}
