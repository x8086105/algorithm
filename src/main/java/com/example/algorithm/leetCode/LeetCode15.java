package com.example.algorithm.leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode15 {

    public static void main(String[] args) {
        int []nums = {0,3,0,1,1,-1,-5,-5,3,-3,-3,0};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums.length < 3){
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for (int k =j+1;k<nums.length;k++){
                    if(nums[i]+nums[j]+nums[k] == 0){
                        boolean isFlag = false;
                        Set<Integer> set2 = new HashSet<>();
                        set2.add(nums[i]);
                        set2.add(nums[j]);
                        set2.add(nums[k]);
                        for(List<Integer> list : lists){
                            Set<Integer> set = new HashSet<>(list);
                            if(set.containsAll(set2) && set.size() == set2.size()){
                                isFlag= true;
                            }
                        }
                        if(isFlag){
                            break;
                        }
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        lists.add(list);
                    }
                }
            }
        }
        return lists;
    }
}
