package com.example.algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeOffer57 {
    private static int sum = 0;
    public static void main(String[] args) {
        findContinuousSequence(9);
        System.out.println("sxx");
    }

    public static int[][] findContinuousSequence(int target) {
        //偶数是不配拥有这个规则的
        if(target % 2 == 0){
            return new int[0][0];
        }

        int start = 1;
        List<int[]> res = new ArrayList<>();
        for( int i = 1;i < target; i++){

            while (sum(i,start) > target){
                start ++;
            }
            if(sum(i,start) < target){
                continue;
            }
            if(sum(i,start) == target){
                //从start到i都是这个数组
                int[] ints = new int[i - start + 1];
                for(int j = start,index = 0;j<= i;j++,index++){
                    ints[index] = j;
                }
                res.add(ints);
            }
        }
        return res.toArray(new int[res.size()][]);
    }

    private static int sum(int i,int start){
       int sum = 0;
        for(int j = start;j<=i;j++){
            sum += j;
        }
        return sum;
    }
}
