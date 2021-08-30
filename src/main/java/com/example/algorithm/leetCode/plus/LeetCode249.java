package com.example.algorithm.leetCode.plus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode249 {

    public static void main(String[] args) {
        String[] ss = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        List<List<String>> lists = groupStrings(ss);
        System.out.println(lists);
    }

    public static List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap();
        for (int i = 0; i < strings.length; i++) {
            String hash = hash(strings[i]);
            List<String> list = map.computeIfAbsent(hash, o->new ArrayList());
            list.add(strings[i]);
        }
        return new ArrayList(map.values());
    }

    public static String hash(String val) {
        char[] chars = val.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            chars[i] =  (char)('a' + (chars[i] - chars[0] + 26) % 26);
        }
        chars[0] = 'a';
        return new String(chars);
    }

}
