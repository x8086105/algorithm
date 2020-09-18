package com.example.algorithm.leetCode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicReference;

/**
 *
 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

 示例:

 s = "abaccdeff"
 返回 "b"

 s = ""
 返回 " "
 */
public class LeetCodeOffer50 {


    public static void main(String[] args) {

    }

    public char firstUniqChar(String s) {
        char[] cs = s.toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(char c: cs){
            map.put(c,map.get(c) == null ? 1 : map.get(c) + 1);
        }
        for(char c : cs){
            if(map.get(c) == 1){
                return c;
            }
        }
        return ' ';
    }
}
