package com.example.algorithm.leetCode;

import java.util.Arrays;
import java.util.HashSet;

public class LeetCodeOffer03 {


    public static void main(String[] args) {
        int []nums = {2, 3, 1, 0, 2, 5, 3};
        int i = findRepeatNumber(nums);
        System.out.println(i);
    }
    public static int findRepeatNumber(int[] nums) {
        //对数组进行排序，从小到大进行排序
        Arrays.sort(nums);
        //遍历 如果左边跟目前一样的话 就是重复的了
        for (int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i + 1]){
                return nums[i];
            }
        }
        return -1;
    }

    public  static int findRepeatNumber2(int[] nums) {
        HashSet<Integer> sets = new HashSet<>();
        for (int i = 0; i < nums.length; i++){
            if(! sets.add(nums[i])){
                return nums[i];
            }
        }
        return -1;
    }
}
