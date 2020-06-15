package com.example.algorithm.leetCode;

/**
 * 动态规划
 * leetCode 392
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

 */
public class DP3 {

    public static void main(String[] args) {
        System.out.println(isSubsequence("asf","afdsfs"));

    }
    public static boolean isSubsequence(String s,String t){
        char []sc = s.toCharArray();
        char []tc = t.toCharArray();
        boolean[][] dp = new boolean[sc.length + 1][tc.length + 1];
        for (int i = 0; i < tc.length; i++) {
            dp[0][i] = true;
        }
        for(int i = 1;i<sc.length+1;i++){
            for (int j = 1;j<tc.length+1;j++){
                if(sc[i-1] == tc[j-1]){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        return dp[sc.length][tc.length];
    }

}
