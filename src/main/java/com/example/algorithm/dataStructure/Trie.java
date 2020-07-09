package com.example.algorithm.dataStructure;

import org.junit.platform.commons.util.StringUtils;

import java.util.TreeMap;

/**
 * Trie 的树状数据结构
 * 本质是一个多叉树来的，跟我们的二叉树没什么区别
 * 根节点是空
 */
public class Trie {
    private class Node{
        public boolean isWord;
        //存放的是他的子节点（想要到达该节点，就应该知道了当前节点是什么）
        public TreeMap<Character,Node> next;

        public Node(boolean isWord){

            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node(){
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie(){
        root = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }

    /**
     * 添加的是一个字符串，分别拆成一个个字符
     * 添加到Trie结构中
     * @param word
     */
    public void add(String word){
        Node cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                cur.next.put(c,new Node());
            }
            cur = cur.next.get(c);
        }
        //以前是不存在这个单词的
        if(!cur.isWord){
            cur.isWord = true;
            size ++ ;
        }
    }

    /**
     * 判断trie中是否包含这个单词
     * @param word
     * @return
     */
    public boolean contains(String word){
        Node cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    /**
     * 判断是否存在以prefix为前缀的单词
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix){
        Node cur = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null){
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }
    /**
     * 递归方式的插入元素
     * @param word
     */
    public void addWithRecursion(String word){
        addWithRecursion(root,word,0);
    }

    private void addWithRecursion(Node node, String word,int index) {
        if (!node.isWord && index == word.length()) {
            node.isWord = true;
            size++;
            return;
        }

        if (word.length() > index) {
            char addLetter = word.charAt(index);
            // 判断trie的下个节点组中是否有查询的字符,如果没有,就添加
            if (node.next.get(addLetter) == null) {
                node.next.put(addLetter, new Node());
            }
            // 基于已经存在的字符进行下个字符的递归查询
            addWithRecursion(node.next.get(addLetter), word, index + 1);
        }
    }

    /**
     * 查询匹配单词word
     * 类似于正则匹配
     * 可以包含. 代表匹配任意字符
     * @param word
     * @return
     */
    public boolean match(String word){
        return match(root,word,0);
    }

    private boolean match(Node node, String word, int index) {
        if(word.length() == index){
            return node.isWord;
        }
        char c = word.charAt(index);
        if(c != '.'){
            if (node.next.get(c) != null){
                return match(node.next.get(c),word,index + 1);
            }else{
                return false;
            }
        }else{
            for(char c1 : node.next.keySet()){
                if(match(node.next.get(c1),word,index + 1)){
                    return true;
                }
            }
            return false;
        }
    }
}
