package com.example.algorithm.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1:
 *
 * 输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
 * 输出: 2
 *
 */
public class LeetCodeOffer39 {
    public static void main(String[] args) {
        int [] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        int k = majorityElement2(nums);
        System.out.println(k);
    }
    public static int majorityElement(int[] nums) {
        int midLength = nums.length / 2;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int count = map.get(nums[i]) == null ? 1 : map.get(nums[i]) + 1;
            if(count > midLength){
                return nums[i];
            }
            map.put(nums[i],count);
        }

        return 0;
    }

    /**
     * 官方题解
     * 摩尔投票法： 核心理念为 “正负抵消” ；时间和空间复杂度分别为 O(N)O(N) 和 O(1)O(1) ；是本题的最佳解法。
     */
    public static int majorityElement2(int[] nums) {
        int score = 0;
        int value = 0;
        for(int i = 0; i < nums.length; i++){
            if (score == 0){
                value = nums[i];
            }
            score += (value == nums[i] ? 1 : -1);
        }

        return value;
    }
}
