package com.example.algorithm.leetCode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * 解法： 回溯算法
 * 最简单的回溯算法
 */
public class LeetCode46 {

    public static void main(String[] args) {
        int[]nums = {1,2,3};
        permute(nums);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = Lists.newArrayList();
        List<Integer> termList = Lists.newArrayList();
        solution(result,termList,nums);
        return result;
    }

    /**
     *
     * @param result
     * @param termList
     * @param nums
     */
    private static void solution(List<List<Integer>> result, List<Integer> termList, int[] nums){
        //终止条件
        if(termList.size() == nums.length){
            result.add(new ArrayList<>(termList));
        }
        for(int num : nums){
            if(!termList.contains(num)){
                termList.add(num);
                solution(result,termList,nums);
                termList.remove(termList.size() - 1);
            }
        }
    }

}
