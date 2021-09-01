package com.example.algorithm.leetCode.plus;

/**
 * 186. 翻转字符串里的单词 II
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例：
 *
 * 输入: ['t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e']
 * 输出: ['b','l','u','e',' ','i','s',' ','s','k','y',' ','t','h','e']
 * 注意：
 *
 * 单词的定义是不包含空格的一系列字符
 * 输入字符串中不会包含前置或尾随的空格
 * 单词与单词之间永远是以单个空格隔开的
 */
public class LeetCode186 {

    public static void main(String[] args) {
        char[]s = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        reverseWords(s);
        System.out.println(s);
    }

    //这道题刷过就知道怎么做了。先各个单词进行翻转，然后再所有进行翻转
    public static void reverseWords(char[] s) {
        //先全局翻转下
        reverseWords(s,0,s.length - 1);
        //各个单词进行翻转
        int start = 0;
        for(int i = 0;i < s.length; i++){
            if(s[i] == ' '){
                reverseWords(s, start, i - 1);
                start = i + 1;
            }
        }
        reverseWords(s,start,s.length - 1);
    }

    private static void reverseWords(char[]a, int start,int end){
        while (start <= end){
            char i = a[start];
            a[start] = a[end];
            a[end] = i;
            start++;
            end--;
        }
    }


}
