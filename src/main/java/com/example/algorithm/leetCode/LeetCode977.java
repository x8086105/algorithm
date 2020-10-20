package com.example.algorithm.leetCode;

import java.util.Arrays;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *
 */
public class LeetCode977 {

    public static void main(String[] args) {
        int []A= {-4,-1,0,3,10};
        int[]result = sortedSquares2(A);
        System.out.println(result);
    }

    public int[] sortedSquares(int[] A) {
        for(int i = 0; i < A.length; i++){
            A[i] = A[i] * A[i];
        }
        Arrays.sort(A);
        return A;
    }

    /**
     * 官方解题思路，完美使用双指针进行解题，挺简单的就是不好想到这个解答方法，还是要多刷刷算法
     * @param A
     * @return
     */
    public static int[] sortedSquares2(int[] A) {
        //1.首先找到临界点 如果在临界点的左边，代表平方后降序，在临界点的右边，平方后升序
        int separatrix = A.length;
        for(int i = 0;i<A.length;i++){
            if(A[i] >= 0){
                separatrix = i;
                break;
            }
        }
        int i = separatrix - 1;
        int []result = new int[A.length];
        int index = 0;
        while (i >= 0 || separatrix < A.length){
            if (i < 0) {
                result[index] = A[separatrix] * A[separatrix];
                separatrix++;
            } else if (separatrix == A.length) {
                result[index] = A[i] * A[i];
                i--;
            } else if (A[i] * A[i] < A[separatrix] * A[separatrix]) {
                result[index] = A[i] * A[i];
                i--;
            } else {
                result[index] = A[separatrix] * A[separatrix];
                separatrix++;
            }

            index ++;

        }
        return result;
    }

    /**
     * 个人认为本题的最优解
     * @return
     */
    public static int[]  sortedSquares3(int[] A){
        //假设前部分是负数 后部分是正数，那么平方之后中间的值是最小的。 两边进行比较，然后填充到最大的那个位置上
        int n = A.length;
        int []result = new int[n];
        for(int i = 0,j = n - 1,pos = n - 1;j>=i;pos -- ){
            if (A[i] * A[i] > A[j] * A[j]) {
                result[pos] = A[i] * A[i];
                ++i;
            } else {
                result[pos] = A[j] * A[j];
                --j;
            }
        }
        return result;
    }
}
