package com.example.algorithm.leetCode;

public class LeetCodeOffer66 {

    public static void main(String[] args) {
        int []A ={1,2,3,4,5};
        int []b = multiply(A);
        for(int i =  0;i<b.length;i++){
            System.out.println(b[i]);
        }
    }
    public static int[] multiply(int[] A) {
        if(A.length == 0){
            return A;
        }
        int []B = new int[A.length];
        B[0] = 1;
        for(int i = 1;i < A.length; i++){
            B[i] = B[i - 1] * A[i -1];
        }
        int temp = 1;
        for(int i = A.length - 2; i >=0; i--){
            temp *= A[i+1];
            B[i]  *= temp;
        }
        return B;
    }
}
