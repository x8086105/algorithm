package com.example.algorithm.leetCode;

/**
 * 假设你有一个数组，其中第\ i i 个元素是股票在第\ i i 天的价格。
 * 你有一次买入和卖出的机会。（只有买入了股票以后才能卖出）。请你设计一个算法来计算可以获得的最大收益。
 */
public class NiuKeShares {

    public int maxProfit (int[] prices) {
        int minValue = prices[0];
        int price = 0;
        for(int i = 1; i<prices.length;i++){
            if(minValue > prices[i]) {
                minValue = prices[i];
            }
            price = Math.max(price, prices[i]-minValue );
        }
        return price;
    }
}
