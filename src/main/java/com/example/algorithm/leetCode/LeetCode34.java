package com.example.algorithm.leetCode;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：
 *
 * 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？
 *
 *
 * 示例 1：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 示例 2：
 *
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 示例 3：
 *
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 */
public class LeetCode34 {

    public static void main(String[] args) {
        int h = 5>>1;
        System.out.println(h);
    }

    /**
     * 已经是有序的了，首先考虑的是   二分查找的方法，找到之后
     * 向前遍历获取start
     * 向后遍历获取end
     * @param nums
     * @param target
     * @return
     */
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int index = binerSearch(nums,target,left,right);
        int []result = new int[2];
        if(index == -1){
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        int leftIndex = index;
        int rightIndex = index;
        for(int i = index;i>=0;i--){
            if(nums[i] < target){
                leftIndex = i + 1;
                break;
            }
            leftIndex = i;
        }
        for(int i = index;i<nums.length;i++){
            if(nums[i] > target){
                rightIndex = i - 1;
                break;
            }
            rightIndex = i;
        }
        result[0] = leftIndex;
        result[1] = rightIndex;
        return result;
    }
    private int binerSearch(int[] nums,int target,int left,int right){
        if(left > right){
            return -1;
        }
        int mid = (right + left) >> 1;
        if(nums[mid] < target){
            //target 在右边
           return binerSearch(nums,target,mid + 1,right);
        }else if(nums[mid] > target){
           return binerSearch(nums,target,left,mid - 1);
        }else{
            return mid;
        }
    }
}
