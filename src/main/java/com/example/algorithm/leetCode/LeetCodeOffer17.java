package com.example.algorithm.leetCode;

public class LeetCodeOffer17 {
    public static void main(String[] args) {
        int [] ss = printNumbers(9);
        System.out.println(ss);
    }
    public  static int[] printNumbers(int n) {
        if (n == 0 || n >= 10){
            return new int[0];
        }
        int end = 0;
        for (int i = n-1;i>=0;i--){
            end += (9* Math.pow(10,i));
        }
        int[]result = new int[end];
        for (int i = 0; i < end; i++){
            result[i]=i+1;
        }
        return result;
    }


}
