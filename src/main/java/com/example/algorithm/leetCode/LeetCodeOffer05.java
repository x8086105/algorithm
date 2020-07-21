package com.example.algorithm.leetCode;

import java.util.Arrays;

/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class LeetCodeOffer05 {

    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace(s));
    }

    public static String replaceSpace(String s) {
       char[] cs = s.toCharArray();
       StringBuilder sb = new StringBuilder();
       for(int i = 0; i < cs.length; i++){
           if(cs[i] == ' '){
               sb.append("20%");
           }else{
               sb.append(cs[i]);
           }

       }
       return sb.toString();
    }
}
