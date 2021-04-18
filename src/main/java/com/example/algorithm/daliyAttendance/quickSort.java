package com.example.algorithm.daliyAttendance;

import java.util.Stack;

/**
 * 再次手写快速排序
 * 规则 选定一个值。比他小的放在左边，比他大的放在右边
 * 有两个指针，i 和 j 一个从头开始遍历，一个从尾向前遍历
 * 两个不重复的时候
 */
public class quickSort {

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
            if ((a[i] == a[j]) && i < j) {
                i++;
            } else {
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        sort1(a, low, i - 1);
        sort1(a, j + 1, high);
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
    private static int partion(int[] arr, int low, int high) {
        //基准值为第一个元素
        int tmp = arr[low];
        low = getLow(arr, low, high, tmp);
        //arr[high] = tmp;
        arr[low]= tmp;
        //return high，返回基准值
        return low;
    }

    static int getLow(int[] arr, int low, int high, int tmp) {
        while (low < high){//从小到大排列
            // 找比基准值小的数放在左边
            while (low < high && arr[high] >= tmp){
                high--;
            }
            if (low >= high){
                arr[low ]= tmp;
                break;
            }else {
                //arr[high] < tmp
                arr[low] = arr[high];
            }
            //找比基准大的值放在右边
            while (low < high && arr[low] <= tmp){
                low++;
            }
            if (low >= high){
                arr[low ]= tmp;
                break;
            }else {
                //arr[low] > tmp
                arr[high] = arr[low];
            }
        }
        return low;
    }

}
