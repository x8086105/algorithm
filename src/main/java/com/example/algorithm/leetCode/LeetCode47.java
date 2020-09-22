package com.example.algorithm.leetCode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode47 {

    public static void main(String[] args) {
        int []nums = {2,2,1,1};

        permuteUnique(nums);
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = Lists.newArrayList();
        List<Integer> termList = Lists.newArrayList();
        solution(result,termList,nums,0,new boolean[nums.length]);
        return result;
    }

    private static void solution(List<List<Integer>> result, List<Integer> termList, int[] nums,int idx,boolean[] used){
        if(termList.size() == nums.length){
            result.add(new ArrayList<>(termList));
        }
        for(int i = 0;i < nums.length; i++){
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }

            used[i] = true;
            termList.add(nums[i]);
            solution(result,termList,nums,idx + 1,used);
            termList.remove(termList.size() - 1);
            used[i] = false;

        }
    }
}
