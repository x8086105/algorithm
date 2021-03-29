package com.example.algorithm.leetCode;

import java.util.HashMap;

/**

 * @author 1
 */
public class LRUCache {

    private HashMap<Integer,ListNode> tab;

    private int capacity;

    private ListNode head;

    private ListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        tab = new HashMap<>(capacity);
        head = new ListNode();
        tail = new ListNode();
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
       ListNode n = tab.get(key);
        if(n == null){
            return -1;
        }
        moveToHead(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        ListNode node = new ListNode(key,value);
        ListNode existsNode = tab.get(node.key);
        if(existsNode != null){
            existsNode.value = node.value;
            moveToHead(existsNode);
            return;
        }
        addToHead(node);
        tab.put(node.key,node);
        if(capacity < tab.size()){
            //移除最后一个元素
            tab.remove(tail.pre.key);
            removeNode(tail.pre);
        }
    }
    
    /**
    将该节点添加到队列的头部
    **/
    private void addToHead(ListNode node){
       node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }


    /**
    将该节点从队列中移除
    **/
    private void removeNode(ListNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
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

    /**
    获取最后末尾的元素
    **/
    private ListNode getTailNode(){
        return tail.pre;
    }
    /**
    移动到队首
    **/
    private void moveToHead(ListNode node){
        removeNode(node);
        addToHead(node);
    }

    private class ListNode {

        private int key;

        private int value;

        private ListNode pre;

        private ListNode next;

        public ListNode(){

        }

        public ListNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
