package com.example.algorithm.BaseAlgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
        sort(nums,0,nums.length - 1);
        List<Integer> s = new ArrayList<>();
        System.out.println(nums);
    }

    /**
     * 选定一个哨兵 ，一般选中间那个作为哨兵
     * @param nums
     */
    private static void sort(int[] nums,int low,int high){
        if(low > high){
            return;
        }
        int sentry = nums[low];
        int i = low;
        int j = high;
        while (i < j){
            while (nums[j] > sentry && i < j){
                j--;
            }
            while (nums[i] < sentry && i < j){
                i++;
            }
            if((nums[i]==nums[j]) && i < j){
                i++;
            }else{
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        sort(nums, low, i - 1);
        sort(nums, j + 1, high);

    }


//    private static void sort(int[] arr,int start,int end){
//        if(start >= end){
//            return;
//        }
//        int pivot = arr[start];
//        int i = start;
//        int j = end;
//        while (i<j) {
//            while ((i<j)&&(arr[j]>pivot)) {
//                j--;
//            }
//            while ((i<j)&&(arr[i]<pivot)) {
//                i++;
//            }
//            if ((arr[i]==arr[j])&&(i<j)) {
//                i++;
//            } else {
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//            }
//        }
//        sort(arr,start,i-1);
//        sort(arr,j+1,end);
//
//    }
}
