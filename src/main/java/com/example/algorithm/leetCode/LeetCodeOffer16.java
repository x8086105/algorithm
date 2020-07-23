package com.example.algorithm.leetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCodeOffer16 {
    public static void main(String[] args) {
        double ss = myPow(2,3);
        System.out.println(ss);
    }
    public static double myPow(double x, int n) {

        Map<Integer,Double> map = new HashMap<>();
        map.put(0,1d);
        map.put(1,x);
        map.put(-1,1/x);
        return myPow(x,n,map);
    }

    private static double myPow(double x, int n, Map<Integer, Double> map) {
        if(map.get(n) != null){
            return map.get(n);
        }
        double result = myPow(x,n/2,map) * myPow(x,(n-n/2),map);
        map.put(n,result);
        return result;
    }
}

