package com.example.algorithm.leetCode;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 */
public class LeetCodeOffer21 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        exchange(nums);
        System.out.println(nums);

    }
    public static int[] exchange(int[] nums) {
        //基本思路 先判断第一个元素是否是偶数 如果是偶数
        //在判断最后一个元素是否是偶数，如果是  -1
        if(nums.length < 2 ){
            return nums;
        }
        int i = 0;
        int j = nums.length - 1;
        while (i < j){
            if(nums[i]%2 == 0){
                //代表前面这个值是偶数
                if(nums[j] % 2 == 0){
                    //后面这个值也是偶数
                    j --;
                }else{
                    //交换
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    i++;
                    j--;
                }
            }else{
                //前面是奇数
                i++;
                if(nums[j] % 2 == 0){
                    //后面这个值也是偶数
                    j --;
                }
            }
        }
        return nums;
    }
}
