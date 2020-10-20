package com.example.algorithm.leetCode;

import java.util.Arrays;

public class LeetCodeOffer61 {
    public static void main(String[] args) {
        int []nums = {0,0,1,2,5};
        System.out.println(isStraight(nums));

    }

    public static boolean isStraight(int[] nums) {
            Arrays.sort(nums);
            int zeroNums = nums[0] == 0 ? 1 : 0;
        int pre = nums[0];
        for(int i = 1;i<nums.length;i++){
            if(nums[i] == 0){
                zeroNums ++;
            }else{
                if(pre != 0){
                    int needZero = nums[i] - pre - 1;
                    if(needZero == 0){
                    }else{
                        if(needZero > zeroNums){
                            return false;
                        }
                        zeroNums =- needZero;
                    }
                }
            }
            pre = nums[i];
        }
        return true;
    }
}

