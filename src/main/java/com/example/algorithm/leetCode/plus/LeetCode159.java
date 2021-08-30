package com.example.algorithm.leetCode.plus;

import java.util.Collections;
import java.util.HashMap;

/**
 * 159. 至多包含两个不同字符的最长子串
 * 给定一个字符串 s ，找出 至多 包含两个不同字符的最长子串 t ，并返回该子串的长度。
 *
 * 示例 1:
 *
 * 输入: "eceba"
 * 输出: 3
 * 解释: t 是 "ece"，长度为3。
 * 示例 2:
 *
 * 输入: "ccaabbb"
 * 输出: 5
 * 解释: t 是 "aabbb"，长度为5。
 */
public class LeetCode159 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }

    /**
     * 这道题的思路使用的是滑动窗口的思路，双指针实现，
     * 需要借助一个map集合，在遍历过程中，当出现三个不一样的字符的
     * 时候，就需要删除掉最左边的， 然后需要统计当前最长的长度（跟之前的长度最对比）
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        int start = 0,end = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 2;
        if(s.length() < 3){
            return s.length();
        }
        /*
         * 下面这块可以直接用while循环，定义一个end 然后end<length
         */
        for(int i = 0;i < s.length();){
            if(map.size() < 3){
                map.put(s.charAt(i),i++);
            }
            if(map.size() == 3){
                //需要统计下长度
                //移除下表最小的
                int delIdx =Collections.min(map.values());
                map.remove(s.charAt(delIdx));
                start = delIdx + 1;
            }
            maxLength = Math.max(maxLength,i - start);

        }
        return maxLength;
    }


}
