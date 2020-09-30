package com.example.algorithm.leetCode;

import java.util.*;

/**
 * 15. 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *
 *
 * 示例：
 *
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class LeetCode15 {
    private static int count, i;
    public static void main(String[] args) {
        int []nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        cal(result,list,nums);
        return result;

    }

    private static void cal(List<List<Integer>> result, List<Integer> list, int[] nums) {
        if(list.size() == 3){
            if((nums[list.get(0)] + nums[list.get(1)] +  nums[list.get(2)]) == 0) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[list.get(0)]);
                tmp.add(nums[list.get(1)]);
                tmp.add(nums[list.get(2)]);
                Collections.sort(tmp);
                if(!result.contains(tmp)){
                    result.add(tmp);
                }
            }
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(list.contains(i)) {
                continue;
            }

            list.add(i);

            cal(result,list,nums);

            list.remove(list.size()-1);
        }



    }
}
