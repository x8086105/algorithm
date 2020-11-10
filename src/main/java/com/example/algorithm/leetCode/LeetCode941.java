package com.example.algorithm.leetCode;

/**
 * 941. 有效的山脉数组
 * 给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。
 *
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 *
 * A.length >= 3
 * 在 0 < i < A.length - 1 条件下，存在 i 使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 */
public class LeetCode941 {
    public static void main(String[] args) {
        int[] A = {1,2,3,4,3,2,2,0};
        boolean flag = validMountainArray3(A);
        System.out.println(flag);
    }
    public static boolean validMountainArray(int[] A) {
        //先升序，再降序
        //用一个值存max，并且，max如果等于前一个值的话，代表开始走下坡路，后面一定是降序，如果出现升序的话，就返回false
        if(A.length < 3){
            return false;
        }
        int preMax;
        int preMidIndex = 0;
        for(int i = 1; i < A.length; i++){
            preMax = Math.max(A[i - 1], A[i]);
            if(preMax == A[i - 1]){
                preMidIndex = i - 1;
                break;
            }
        }
        int afterMax;
        int afterMidIndex = 0;
        for(int i = A.length - 2; i >= 0; i--){
            afterMax = Math.max(A[i + 1], A[i]);
            if(afterMax == A[i + 1]){
                afterMidIndex = i + 1;
                break;
            }
        }

        if(afterMidIndex == A.length - 1 || preMidIndex == 0){
            return false;
        }
        if(afterMidIndex == preMidIndex){
            return true;
        }
        return false;
    }


    /**
     * 采用双指针
     */
    public static boolean validMountainArray2(int[] A) {
        if(A.length < 3){
            return false;
        }
        int i = 0;
        int j = A.length - 1;
        boolean preFlag = false;
        boolean afterFlag = false;
        while (i != j){
            System.out.println("--");
            if(i < A.length - 1){
                if(Math.max(A[i + 1], A[i]) != A[i] && !preFlag){
                    i++;
                }else {
                    preFlag  = true;
                }
            }
            if(j > 0){
                if(Math.max(A[j - 1], A[j]) != A[j] && !afterFlag){
                    j--;
                }else {
                    afterFlag = true;
                }
            }
            if(preFlag && afterFlag || i == 0 || j == A.length - 1){
                System.out.println(i + "_" + j);
                return false;
            }
        }
        return true;
    }

    /**
     * 效率高的双指针
     * @param A
     * @return
     */
    public static boolean validMountainArray3(int[] A) {
        int j = A.length;
        int i = 0;

        // 递增扫描
        while (i + 1 < j && A[i] < A[i + 1]) {
            i++;
        }

        // 最高点不能是数组的第一个位置或最后一个位置
        if (i == 0 || i == j - 1) {
            return false;
        }

        // 递减扫描
        while (i + 1 < j && A[i] > A[i + 1]) {
            i++;
        }

        return i == j - 1;
    }
}
