package com.example.algorithm.leetCode;

import java.util.Arrays;

/**
 * 动态规划1
 *最长递增子序列
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 根据leetCode上视频讲解会好看点 第300题
 */
public class DP1 {

    public static void main(String[] args) {
        int []arrs = {10,9,2,5,3,7,101,18};
        System.out.println(maxLength(arrs));
    }

    private static int maxLength(int []nums){
        int[] dp = new int[nums.length];
        // base case：dp 数组全都初始化为 1
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
