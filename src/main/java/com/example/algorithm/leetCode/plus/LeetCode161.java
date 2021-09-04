package com.example.algorithm.leetCode.plus;

/**
 * 161. 相隔为 1 的编辑距离
 * 给定两个字符串 s 和 t，判断他们的编辑距离是否为 1。
 *
 * 注意：
 *
 * 满足编辑距离等于 1 有三种可能的情形：
 *
 * 往 s 中插入一个字符得到 t
 * 从 s 中删除一个字符得到 t
 * 在 s 中替换一个字符得到 t
 * 示例 1：
 *
 * 输入: s = "ab", t = "acb"
 * 输出: true
 * 解释: 可以将 'c' 插入字符串 s 来得到 t。
 * 示例 2:
 *
 * 输入: s = "cab", t = "ad"
 * 输出: false
 * 解释: 无法通过 1 步操作使 s 变为 t。
 * 示例 3:
 *
 * 输入: s = "1203", t = "1213"
 * 输出: true
 * 解释: 可以将字符串 s 中的 '0' 替换为 '1' 来得到 t。
 */
public class LeetCode161 {

    public static void main(String[] args) {
        final boolean oneEditDistance = isOneEditDistance("ab", "adf");
        System.out.println(oneEditDistance);
    }

    public static boolean isOneEditDistance(String s, String t) {
        if(s.equals(t)){
            return false;
        }
        int sLength = s.length();
        int tLength = t.length();
        if(sLength > tLength){
            return isOneEditDistance(t,s);
        }
        //只要走到这里，代表tLength一定是大于sLength的
        if(tLength - sLength > 1){
            return false;
        }
        for(int i = 0;i < sLength; i++){
            if(s.charAt(i) != t.charAt(i)){
                if(tLength != sLength){
                    return s.substring(i).equals(t.substring(i + 1));
                }else{
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
            }
        }
        return true;
    }
}
