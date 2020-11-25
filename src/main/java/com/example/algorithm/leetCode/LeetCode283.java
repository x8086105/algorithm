package com.example.algorithm.leetCode;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class LeetCode283 {

    public static void main(String[] args) {
        int []nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(nums);
    }

    /**
     * 采用双指针，其中一个指针指向元素只能为0
     * 另一个指针指向元素只能为非0的
     * 两个进行交换，如果当发生数组越界的话 就说明已经移动完毕了
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        int i = 0;
        int j = 1;
        while (i < nums.length && j < nums.length){
            if(nums[i] != 0){
                i++;
                j++;
                continue;
            }
            if(nums[j] == 0){
                j++;
                continue;
            }
            if(nums[i] == 0 && nums[j] != 0 && i < j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j++;
            }

        }
    }

    /**
     * 双指针
     * 一个指向头部，一个指向尾部
     * 当头部的为0 尾部的为非0 进行交换，
     *
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        int  left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
            }
            right++;
        }
    }
}
