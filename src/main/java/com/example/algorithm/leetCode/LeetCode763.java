package com.example.algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 */
public class LeetCode763 {

    public List<Integer> partitionLabels(String S) {
        int [] last = new int[26];
        char[] sc = S.toCharArray();
        int length = sc.length;
        //将每个字母的最后一个下标存起来
        for(int i = 0; i < length; i++){
            last[sc[i] - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<Integer>();
        int start = 0,end = 0;

        for(int i = 0; i < length; i++){
            end = Math.max(end,last[sc[i] - 'a']);
            if(i == end){
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
