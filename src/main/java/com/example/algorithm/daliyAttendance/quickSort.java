package com.example.algorithm.daliyAttendance;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 再次手写快速排序
 * 规则 选定一个值。比他小的放在左边，比他大的放在右边
 * 有两个指针，i 和 j 一个从头开始遍历，一个从尾向前遍历
 * 两个不重复的时候
 */
public class quickSort {

    public static void main(String[] args) {
        int[] nums={1,2,1,2,1,4,5,1,1,2};
        //sort( 0, nums.length - 1,nums);
        quickSort(nums);
        for(int a : nums){
            System.out.println(a);
        }
    }

    //使用
    private static void sort1(int[] a, int low, int high) {
        if (low > high) {
            return;
        }
        //基数
        int target = a[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (j > i && a[j] > target) {
                j--;
            }
            while (i < j && a[i] < target) {
                i++;
            }
            if (i >= j) {
                break;
            }
            swap(a,a[i],a[j]);
            i++;
            j--;
        }
        sort1(a, low, i - 1);
        sort1(a, j + 1, high);
    }
    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    /**
     * 使用非递归进行运算
     * @param arr
     */
    //非递归快速排序
    private static void quickSort(int[] arr) {
        //建立栈
        Stack<Integer> stack = new Stack<>();
        int low = 0;
        int high = arr.length - 1;
        int par = partion(arr,low,high);

        //左右两边元素个数 >= 2, low high入栈
        if (par > low + 1){
            stack.push(low);
            stack.push(par - 1);
        }
        if (par < high - 1){
            stack.push(par + 1);
            stack.push(high);
        }
        while (!stack.empty()){
            high = stack.pop();
            low = stack.pop();
            //拿到左右边界，再进行快排
            par = partion(arr,low,high);

            //左右两边元素个数 >= 2, low high入栈
            if (par > low + 1){
                    stack.push(low);
                    stack.push(par - 1);
                }
                if (par < high - 1){
                    stack.push(par + 1);
                stack.push(high);
            }
        }
    }
    /**
     *     建立在一趟快速排序的基础上
     */
    private static int partion(int[] a, int low, int high) {
        int i = low;
        int j = high + 1;
        int target = a[low];
        while(true){
            while (a[++i] < target && i  <high){

            }
            while (a[--j] > target && j > low){

            }
            if(i >= j){
                break;
            }
            swap(a,i,j);
        }
        //将第一个元素进行替换
        swap(a,low,j);
        return j;
    }



    //采用标准的递归算法排序，以及借鉴算法圣经中的快排讲解
    private static void sort(int lg,int gt,int[]a){
        if(gt <= lg) return;
        int pIndex = partion(a,lg,gt);
        sort(lg,pIndex - 1,a);
        sort(pIndex + 1, gt,a);
    }


}
