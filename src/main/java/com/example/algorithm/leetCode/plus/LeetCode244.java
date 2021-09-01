package com.example.algorithm.leetCode.plus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 244. 最短单词距离 II
 * 请设计一个类，使该类的构造函数能够接收一个单词列表。然后再实现一个方法，该方法能够分别接收两个单词 word1 和 word2，并返回列表中这两个单词之间的最短距离。您的方法将被以不同的参数调用 多次。
 *
 * 示例:
 * 假设 words = ["practice", "makes", "perfect", "coding", "makes"]
 *
 * 输入: word1 = “coding”, word2 = “practice”
 * 输出: 3
 * 输入: word1 = "makes", word2 = "coding"
 * 输出: 1
 * */

public class LeetCode244 {

    class WordDistance {

        private HashMap<String, ArrayList<Integer>> map;

        public WordDistance(String[] words) {
            this.map = new HashMap<>();
            for (int i = 0; i < words.length; i++) {
                ArrayList<Integer> loc = this.map.getOrDefault(words[i], new ArrayList<Integer>());
                loc.add(i);
                this.map.put(words[i], loc);
            }
        }

        public int shortest(String word1, String word2) {
            ArrayList<Integer> loc1, loc2;

            // Location lists for both the words
            // the indices will be in SORTED order by default
            loc1 = this.map.get(word1);
            loc2 = this.map.get(word2);

            int l1 = 0, l2 = 0, minDiff = Integer.MAX_VALUE;
            while (l1 < loc1.size() && l2 < loc2.size()) {
                minDiff = Math.min(minDiff, Math.abs(loc1.get(l1) - loc2.get(l2)));
                if (loc1.get(l1) < loc2.get(l2)) {
                    l1++;
                } else {
                    l2++;
                }
            }

            return minDiff;
        }
    }

}
