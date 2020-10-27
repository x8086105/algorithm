package com.example.algorithm.leetCode;

import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * 示例:
 *
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 *
 *   滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 */
public class LeetCode59 {

    public static void main(String[] args) {
        int []nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] result = maxSlidingWindow(nums,k);
        System.out.println(result);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || k < nums.length){
            return new int[0];
        }
        Queue<Integer> deque = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2){
                    return -1;
                }
                if(o1.equals(o2)){
                    return 0;
                }
                return  1;
            }
        });
        int []result = new int[nums.length - 2];
        //优先级队列
        for(int i = 0;i<nums.length;i++){
            if(deque.size() < 3){
                deque.add(nums[i]);
            }
            if(deque.size() == 3){
                result[i - 2] = deque.peek();
                deque.remove(nums[i - 2]);
            }
        }
        return result;
    }


}
