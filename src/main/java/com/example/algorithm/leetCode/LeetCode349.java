package com.example.algorithm.leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * 349. 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 */
public class LeetCode349 {

    public static void main(String []args){
        int[] nums1 = {1,2};
        int[] nums2 = {1,1};
        Arrays.sort(nums2);
        boolean s = binerSearch(4,0,nums2.length - 1,nums2);
        int []result = intersection(nums1,nums2);

        System.out.println(result);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length == 0||  nums2.length == 0){
            return new int[0];
        }
        Arrays.sort(nums2);
        HashSet<Integer> set = new HashSet<>();
        int end = nums2.length - 1;
        for(int i = 0; i < nums1.length; i++){
            int tartNum = nums1[i];
            if(binerSearch(tartNum,0,end,nums2)){
                set.add(tartNum);
            }
        }
        int []result = new int[set.size()];
        int j = 0;
        for(Integer i : set){
            result[j] = i;
            j++;
        }
        return result;
    }

    /**
     * 二分查找目标元素是否在该集合中(递归)
     * @param targetNum
     * @param nums
     * @return
     */
    private static boolean binerSearch(int targetNum, int start, int end, int[] nums){
        if(start > end){
            return false;
        }
        int mid = (end + start)/2;
        if(nums[mid] == targetNum){
            return true;
        }
        if(nums[mid] < targetNum){
            return binerSearch(targetNum,mid + 1,end,nums);
        }else if (nums[mid] > targetNum){
            return binerSearch(targetNum,start,mid - 1,nums);
        }
        return false;
    }


}
