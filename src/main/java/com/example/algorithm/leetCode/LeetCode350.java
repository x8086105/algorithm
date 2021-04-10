package com.example.algorithm.leetCode;

import java.util.ArrayList;

public class LeetCode350 {

    public static int[] intersect(int[] nums1, int[] nums2) {
        quickSort(nums1,0,nums1.length - 1);
        quickSort(nums2,0,nums2.length - 1);

        int i = 0,j = 0;
        ArrayList<Integer> rs = new ArrayList<>();
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i] > nums2[j]){
                j++;
            }else{
                rs.add(nums1[i]);
                i++;
                j++;

            }
        }
        int size = 0;
        int [] result = new int[size = rs.size()];
        for(int k = 0; k < size; k++){
            result[k] = rs.get(k);
        }
        return result;
    }




    private static void quickSort(int [] nums,int start,int end){
        if(start > end){
            return;
        }
        //快速排序，都是从小到大排序
        int v = nums[start];
        int i = start;
        int j = end;
        while(i < j){
            while(v < nums[j] && j > i){
                j--;
            }
            while(v > nums[i] && i < j){
                i++;
            }
            if((nums[i]==nums[j]) && i < j){
                i++;
            }else if(i < j){
                int n = nums[i];
                nums[i] = nums[j];
                nums[j] = n;
            }
        }
        quickSort(nums, start,i - 1);
        quickSort(nums, j + 1,end);


    }

    public static void main(String[] args) {
     int[]s1={1,2,2,1};
        int [] s2 = {2,2};
        int []result = intersect(s1,s2);
        System.out.println(result);
    }
}
