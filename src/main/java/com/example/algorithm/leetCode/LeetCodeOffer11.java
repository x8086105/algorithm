package com.example.algorithm.leetCode;

import java.util.Arrays;

public class LeetCodeOffer11 {
    public static void main(String[] args) {
        int []numbers = {3,4,5,1,2};
        int min = minArray(numbers);
        System.out.println(min);
    }

    public static int minArray(int[] numbers) {
//        if(numbers.length == 0){
//            return  -1;
//        }
//        Arrays.sort(numbers);
//        return numbers[0];
        if (numbers.length == 0) {
            return -1;
        }
        int pre = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if(pre > numbers[i]){
                return numbers[i];
            }
            if(i != numbers.length - 1){
                pre = numbers[i];
            }else{
                return numbers[0];
            }

        }
        return -1;
    }
}
