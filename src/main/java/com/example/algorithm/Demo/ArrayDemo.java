package com.example.algorithm.Demo;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class ArrayDemo {
    //两个数组 增序排序 A B m n 求第K大元素

    public static void main(String[] args) {
        int []A = {1,2,3,4,5};
        int []B = {4,5,6,7,8};
        int result = solution(A,B,3);
        System.out.println(result);
    }
    //1
    private static int solution(int[]A,int []B,int k){

        int m = A.length;
        int n = B.length;
        if(k > m + n){
            return -1;
        }
        int a1= A.length - 1;
        int a2 = B.length - 1;
        int result = -1 ;
        while (a1 > 0 && a2 > 0 && k > 0){
            if(A[a1] >= B[a2]){
                result = A[a1];
                a1 --;
            }else if(A[a1] < B[a2]){
                result = B[a2];
                a2 --;
            }
            k--;
        }
        if(a1 == 0 && k !=0){
            result = B[B.length - k];
        }else if(a2 == 0 && k != 0){
            result = A[A.length - k];
        }
        return result;
    }
}
