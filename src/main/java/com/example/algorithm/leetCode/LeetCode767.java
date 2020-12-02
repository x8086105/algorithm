package com.example.algorithm.leetCode;

import org.junit.platform.commons.util.StringUtils;

/**
 * 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 *
 * 若可行，输出任意可行的结果。若不可行，返回空字符串。
 *
 * 示例 1:
 *
 * 输入: S = "aab"
 * 输出: "aba"
 * 示例 2:
 *
 * 输入: S = "aaab"
 * 输出: ""
 *
 * 输入: S = "vvvlo"
 * 输出  "vlvov"
 */
public class LeetCode767 {

    public static void main(String[] args) {
        String result = reorganizeString("vvvlo");
        System.out.println(result);
    }


    public  static String reorganizeString(String S) {
        StringBuilder result = new StringBuilder();
        int[] count = new int[26];
        int max = 0;
        for(char c : S.toCharArray()){
            count[c - 'a'] ++;
            max = Math.max(max, count[c - 'a'] );
        }
        if(max > S.length() - max + 1){
            return "";
        }
        //先判断是否能完成这个任务

        while (result.length() < S.length()){
            //每次都取出最大的那个值，如果跟上面一样 取出第二个大的那个值
            int maxI = 0;
            int preI = 0;
            for(int i = 0; i < 26; i++){
                if(maxI < count[i]){
                    if(result.length() > 0){
                        if(result.charAt(result.length() - 1) != (char)(i + 'a')){
                            maxI = count[i];
                            preI = i;
                        }
                    }else{
                        maxI = count[i];
                        preI = i;
                    }
                }
            }
            count[preI] --;
            char lastChar = (char)(preI + 'a');
            result.append(lastChar);
        }
        return result.toString();
    }
}
