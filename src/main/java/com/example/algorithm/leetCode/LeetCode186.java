package com.example.algorithm.leetCode;

import com.example.Person;

import java.util.*;

public class LeetCode186 {
    public static void reverseWords(char[] s) {
        //精髓 先对每个单词实现翻转，然后对整个数组进行翻转
        int start = 0;
        int end = 0;
        while (end < s.length){
            if(s[end] == ' ' || end == s.length - 1){
                helper(s,start,end == s.length - 1 ? end:end - 1);
                start = end + 1;
            }
            end++;
        }
        helper(s, 0, s.length - 1);
    }

    private static void helper(char[] s,int start,int end){
        while(start < end){
            char d = s[start];
            s[start] = s[end];
            s[end] = d;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        char []s  = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        reverseWords(s);
        System.out.println(s);
    }

}
