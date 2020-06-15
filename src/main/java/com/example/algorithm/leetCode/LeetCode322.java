package com.example.algorithm.leetCode;

import java.util.Arrays;

/**
 * DP 零钱兑换问题
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 *
 * 详解：动态规划 通过写出动态规划方程为
 * dp[i] = Math.min(dp[amount-coins[x]] + 1, dp[amount])
 */
public class LeetCode322 {
    public static void main(String[] args) {
        int []coins = {1, 2, 5};
        int amount = 11;
        System.out.println(coinChange(coins,amount));
    }

    public static int coinChange(int[] coins, int amount) {
        //因为dp[amount] 所以 长度应为amount + 1
        int []dp = new int[amount + 1];
        //初始化dp里面的值(一般为最大值)
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        //给第一个值默认设置成0
        dp[0] = 0;
        for(int i = 0;i<dp.length; i++){
            for(int c : coins){
                if(i - c < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i - c] + 1,dp[i]);
            }
        }
        return (dp[amount] == Integer.MAX_VALUE - 1) ? -1 : dp[amount];

    }
}
