package com.example.algorithm.BaseAlgorithm;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

/*
首次在成都，第一次写快速排序
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int[] nums={1,2,1,2,1,4,5,1,1,2};
        sort2( nums);
        for(int a : nums){
            System.out.println(a);
        }
    }

    private void sort(int []a,int low,int high){
        if(low >= high){
            return;
        }
        int p = partion(a,low,high);
        sort(a,p + 1, high);
        sort(a,low, p - 1);

    }

    /**
     * 非递归的实现方式
     * @param a
     */
    private static void sort2(int [] a){
        Stack<Integer> stack = new Stack<>();
        int low = 0;
        int high = a.length - 1;
        int par = partion(a,low,high);
        //当左右边元素相差2个元素的时候
       if(par > low + 1){
           stack.push(low);
           stack.push(par - 1);
       }
       if(par + 1 < high){
           stack.push(par + 1);
           stack.push(high);
       }
       while (! stack.empty()){
           high = stack.pop();
           low = stack.pop();
           par = partion(a,low,high);
           if(par > low + 1){
               stack.push(low);
               stack.push(par - 1);
           }
           if(par + 1 < high){
               stack.push(par + 1);
               stack.push(high);
           }
       }
    }

    private static int partion(int[] a, int low,int high){
        int i = low;
        int j = high + 1;
        //设置一个哨兵
        int target = a[low];
        while(true){
            while(a[++i] < target && i < high);

            while(a[--j] > target && j > low);

            if(i >= j){
                break;
            }
            swap(a,i,j);
        }
        swap(a,low,j);
        return j;
    }
    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
