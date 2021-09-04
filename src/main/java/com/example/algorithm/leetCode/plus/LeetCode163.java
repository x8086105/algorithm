package com.example.algorithm.leetCode.plus;

import java.util.ArrayList;
import java.util.List;

/**
 * 163. 缺失的区间
 * 给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。
 * <p>
 * 示例：
 * <p>
 * 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
 * 输出: ["2", "4->49", "51->74", "76->99"]
 */
public class LeetCode163 {

    public static void main(String[] args) {
        List<String> missingRanges = findMissingRanges(new int[]{}, 1, 1);
        System.out.println(missingRanges);
    }

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<>();

        if (nums.length == 0) {
            list.add(helper(lower - 1, upper + 1));
            return list;
        }
        if (lower < nums[0]) {
            list.add(helper(lower - 1, nums[0]));
        }
        for (int idx = 0; idx < nums.length - 1; ++idx) {
            if (nums[idx] + 1 != nums[idx + 1]) {
                list.add(helper(nums[idx], nums[idx + 1]));
            }
        }

        list.add(helper(nums[nums.length - 1], upper + 1));
        return list;
    }

    private static String helper(int lower, int upper) {
        StringBuilder sb = new StringBuilder();
        if (upper - lower == 2) {
            sb.append(upper - 1);
        } else if (upper - lower > 2) {
            sb.append(lower + 1).append("->").append(upper - 1);
        }
        return sb.toString();
    }

}
