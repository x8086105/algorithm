package com.example.algorithm.leetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1528 {

    public static void main(String[] args) {

    }
    public String restoreString(String s, int[] indices) {
        char [] cs = s.toCharArray();
        char [] cs2 = new char[cs.length];
        for(int i = 0 ;i < indices.length;i++){
            cs2[indices[i]] = cs[i];
        }

        return new String(cs2);
    }
}
