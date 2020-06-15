package com.example.algorithm.leetCode;

/**
 * 动态规划四
 * BiliBili 动态规划详解
 * 选择两个不相邻的数，使得和最大
 * 比如 4 1 1 9 1
 * 选择的是 4 9 ==13
 */
public class DP4 {
    public static void main(String[] args) {
        int []nums = {1,2};
        System.out.println(maxValue(nums));
    }
    public static int maxValue(int []nums){
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        int []dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<nums.length ; i++){
            dp[i] = Math.max(dp[i-2]+nums[i],dp[i-1]);
        }

        return dp[nums.length - 1];
    }
}
