package com.example.algorithm.daliyAttendance;

import com.example.algorithm.dataStructure.Set;

import java.util.HashSet;

public class Random100 {

    public static void main(String[] args) {
        HashSet<Integer> result = new HashSet<Integer>(10);
        while (result.size() < 10){
            Double d = Math.random();
            System.out.println(d);
            result.add((int)(d * 100));
        }
        System.out.println(result);
    }
}
