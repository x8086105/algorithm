package com.example.algorithm.leetCode.plus;

/**
 * 243. 最短单词距离
 * 给定一个单词列表和两个单词 word1 和 word2，返回列表中这两个单词之间的最短距离。
 *
 * 示例:
 * 假设 words = ["practice", "makes", "perfect", "coding", "makes"]
 *
 * 输入: word1 = “coding”, word2 = “practice”
 * 输出: 3
 * 输入: word1 = "makes", word2 = "coding"
 * 输出: 1
 */
public class LeetCode243 {

    public static void main(String[] args) {
        String []s = {"practice", "makes", "perfect", "coding", "makes"};
        final int i = shortestDistance(s,"coding","practice");
        System.out.println(i);
    }

    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        int l = -1,r = -1;
        int minLength = wordsDict.length;
        for(int i = 0; i < wordsDict.length; i++){
            if(wordsDict[i].equals(word1)){
                l = i;
            }
            if(wordsDict[i].equals(word2)){
                r = i;
            }
            if(l != -1 && r != -1){
                minLength = Math.min(minLength,Math.abs(r - l));
            }
        }
        return minLength;
    }
}
