package com.example.algorithm.leetCode;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 */
public class LeetCodeOffer38 {
    public static void main(String[] args) {


    }

    public static String[] permutation(String s) {
        char []cs = s.toCharArray();
        int length = 1;
        for(int i = 1;i <= cs.length; i++){
            length *= i;
        }
        String []result = new String[length];
        //String repStr = permutation(s,0);
        return result;
    }

}
