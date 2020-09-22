package com.example.algorithm.leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 *
 * 示例 1：
 *
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *  
 *
 * 示例 2：
 *
 * 输入：[3,2]
 * 输出：-1
 *  
 *
 * 示例 3：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 */
public class LeetCode17_10 {

    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        Map<Integer,Integer> num2Count = new HashMap<>();
        int length = nums.length;
        for(int i = 0; i<nums.length; i++){
            int val = nums[i];
            num2Count.put(val,num2Count.get(val) == null? 1 : num2Count.get(val) + 1);
            if(length/2 < num2Count.get(val)){
                return val;
            }
        }
        return -1;
    }
}
