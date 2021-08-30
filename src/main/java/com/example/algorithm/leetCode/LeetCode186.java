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
        HashMap<Integer,Integer> map = new HashMap<>();
       for(Map.Entry<Integer,Integer> entry : map.entrySet()){

       }
    }
    public List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strings) {
            char[] seq = str.toCharArray();
            // "" 情况
            if (seq.length == 0) {
                map.put("", new ArrayList<String>() {{add(str);}});
                continue;
            }
            // 转为以a开头的 作为key
            if (seq[0] != 'a') {
                for (int i = 1; i < seq.length; ++i)
                    seq[i] = (char) ((seq[i] - seq[0] + 26) % 26 + 'a');
                seq[0] = 'a';
            }
            String key = String.valueOf(seq);
            map.computeIfAbsent(key, x -> new LinkedList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
