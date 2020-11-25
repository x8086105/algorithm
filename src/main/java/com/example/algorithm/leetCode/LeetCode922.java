package com.example.algorithm.leetCode;

/**
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *
 */
public class LeetCode922 {

    public static void main(String[] args) {
        int[] A = {4,2,5,7};
        int []AA = sortArrayByParityII(A);
        System.out.println(AA);
    }

    /**
     * 双指针，空间复杂度为O(1)
     * @param A
     * @return
     */
    public static int[] sortArrayByParityII(int[] A) {
        //两个指针，i指向偶数 j指向奇数
        int i = 0;
        int j = 1;
        while (i < A.length && j < A.length){
            if(A[i] % 2 != 0 && A[j] %2 == 0){
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i += 2;
                j += 2;
                continue;
            }
            if(A[i] % 2 == 0){
                i += 2;
            }
            if(A[j] % 2 != 0){
                j += 2;
            }

        }
        return A;
    }

    /**
     * 双指针，空间复杂度为O(n)
     * @param A
     * @return
     */
    public static int[] sortArrayByParityII2(int[] A) {
        //两个指针，i指向偶数 j指向奇数
        int i = 0;
        int j = 1;
        int[]result = new int[A.length];
        for(int k = 0; k < A.length; k++){
            if(A[k] % 2 == 0){
                result[i] = A[k];
                i += 2;
            }else{
                result[j] = A[k];
                j += 2;
            }
        }
        return result;
    }
}
