package com.example.algorithm.leetCode;

public class LeetCodeOffer29 {


    public static void main(String[] args) {

    }

    public static int[] spiralOrder(int[][] matrix) {
        int height = matrix.length;
        if(height == 0){
            return null;
        }
        if(height == 1){
            return matrix[0];
        }
        int length = matrix[0].length;

        int startX = 0;
        int startY = 0;
        int count = 0;
        int [] result = new int[height * length];
        while (count < height * length){
            if(startY < height/2 && )
            count ++;
        }
        return null;
    }

}
