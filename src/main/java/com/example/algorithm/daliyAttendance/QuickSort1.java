package com.example.algorithm.daliyAttendance;

import java.util.Stack;

/**
 * 每日一遍快排算法
 */
public class QuickSort1 {

    public static void main(String[] args) {
    }
    //使用递归进行排序
    private void quickSort(int low,int high,int []nums){
        if(low >= high){
            return;
        }
        int p = partion(low,high,nums);
        quickSort(low,p - 1,nums);
        quickSort(p + 1,high,nums);
    }

    private int partion(int low,int high,int []nums){
        int i = low;
        int j = high + 1;
        int target = nums[i];
        while (i < j){
            while (nums[++i] < target && i < high){

            }
            while (nums[--j] > target && j > low){

            }
            if(i < j){
                swap(i,j,nums);
            }
        }
        swap(low,j,nums);
        return j;
    }

    private void swap(int i,int j,int[]nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 非递归去实现
     * @param nums
     */
    private void quickSort2(int []nums){
        Stack<Integer> stack = new Stack<Integer>();
        int low = 0;
        int high = nums.length - 1;
        if(low >= high){
            return;
        }
        stack.push(low);
        stack.push(high);
        while (!stack.empty()){
            high = stack.pop();
            low = stack.pop();
            int p = this.partion(low,high,nums);
            if (p > low + 1){
                stack.push(low);
                stack.push(p - 1);
            }
            if (p < high - 1){
                stack.push(p + 1);
                stack.push(high);
            }
        }




    }

}
