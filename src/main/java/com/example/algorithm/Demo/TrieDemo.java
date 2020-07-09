package com.example.algorithm.Demo;

import com.example.algorithm.dataStructure.Trie;

/**
 * 测试Trie的效率
 */
public class TrieDemo {
    public static void main(String[] args) {
        Trie trie = new Trie();
        String apple = "apple";
        String person = "person";
        String app = "app";

        trie.add(app);
        trie.add(apple);
        trie.add(person);
        String match = "a.p";
        System.out.println(trie.match(match));
        String prefix  = "app";
        System.out.println(trie.isPrefix(prefix));
        String contains = "person";
        System.out.println(trie.contains(contains));
    }
}
