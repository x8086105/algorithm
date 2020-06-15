package com.example.algorithm.leetCode;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 *
 * 返回 false.
 *
 */
public class LeetCode392 {
    public static void main(String[] args) {
        String s = "bb", t = "acdsbv";
        System.out.println(isSubsequence(s,t));
    }
    public static boolean isSubsequence(String s, String t) {
        if(s.length() > t.length()){
            return false;
        }
        if(s.length() == t.length()){
            if(! s.equals(t)){
                return false;
            }
        }
        char [] sa = s.toCharArray();
        char [] ta = t.toCharArray();
        int j = 0;
        int count = 0;
        for(;j<ta.length;j++){
            if((sa[count] +"").equals(ta[j]+"")){
                count ++;
                break;
            }
        }

        if(count == sa.length){
            return true;
        }
        return false;
    }
}
