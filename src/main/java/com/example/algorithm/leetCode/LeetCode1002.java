package com.example.algorithm.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 */
public class LeetCode1002 {
    public static void main(String[] args) {
        String []A = {"bella","label","roller"};
        List<String> s  = commonChars2(A);
        System.out.println(s);
    }
    public static List<String> commonChars(String[] A) {
        //用来存结果
        List<HashMap<String,Integer>> list = new ArrayList<>();
        for(String a : A){
            HashMap<String,Integer> map = new HashMap<>();
            char[] ar = a.toCharArray();
            for(char cr : ar){
                map.put(cr+"",map.get(cr+"") == null ? 1 : map.get(cr+"") + 1);
            }
            list.add(map);
        }
        if(list.size() <= 0){
            return new ArrayList<>();
        }
        char[] ca = A[0].toCharArray();
        List<String> result = new ArrayList<>();
        for(char c : ca){
            int min = list.get(0).get(c+"") == null ? 0 : list.get(0).get(c+"") ;
            for(HashMap<String,Integer> map : list){
                //在a中有多少个c
                min = Math.min(min,map.get(c+"") == null ? 0 : map.get(c+""));
            }
            if(!result.contains(c+"")){
                for(int i = 0;i<min;i++){
                    result.add(c+"");

                }
            }
        }
        return result;
    }


    public static List<String> commonChars2(String[] A) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word: A) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                ++freq[ch - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }

}
