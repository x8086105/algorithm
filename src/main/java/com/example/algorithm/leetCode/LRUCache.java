package com.example.algorithm.leetCode;

import java.util.HashMap;

/**
最近最少使用，首先得要用链表，用来进行元素的移动，使用过的放到对首，没有的放到队尾
**/
public class LRUCache {
    private int capacity;
    private HashMap<Integer,Node> tab;
    private Node head = new Node();
    private Node tail = new Node();


    public LRUCache(int capacity) {
        this.capacity = capacity;
        tab = new HashMap<>(capacity);
        head.next = tail;
        tail.pre = head;
    }
    //获取元素了
    public int get(int key) {
        Node v = tab.get(key);
        if(v == null){
            return -1;
        }
        //移动当前元素到对首
        //首先 自己先独立出来
        moveToHead(v);
        return v.value;
    }
    
    public void put(int key, int value) {
        //首先判断是否超过容量，如果超过，移除队尾元素，tail 指向队尾
        Node v = tab.get(key);
        if(v == null){
            Node node = new Node(key,value);
            tab.put(key,node);
            addToHead(node);
            if(tab.size() > capacity){
                Node tail = removeTail();
                // 删除哈希表中对应的项
                tab.remove(tail.key);
            }
        }else{
            v.value = value;
            moveToHead(v);
        }

    }

    private void addToHead(Node node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }
    private Node removeTail() {
        Node res = tail.pre;
        removeNode(res);
        return res;
    }


    /**
    * 内部节点
    **/
    private class Node{
        /**
        下一个节点
        **/
        private Node next;
        /**
        上一个节点
        **/
        private Node pre;
        /**
        用来保存value
        **/
        private int value;

        private int key;

        private Node(int key,int value){
            this.key = key;
            this.value = value;
        }

        private Node(){
        }

    }

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);

    }
}
