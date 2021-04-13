package com.example.algorithm.leetCode;

import io.netty.handler.codec.MessageToByteEncoder;

import java.util.HashMap;

/**
 * @author 1
 */
public class LRUCache {

    private HashMap<Integer,Node> tab;

    private int capacity;

    private LinkedList linkedList;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        tab = new HashMap<>(capacity);
        linkedList = new LinkedList();
    }
    
    public int get(int key) {
       Node n = tab.get(key);
        if(n == null){
            return -1;
        }
        linkedList.moveToHead(n);
        return n.value;
    }
    
    public void put(int key, int value) {
        Node node = new Node(key,value);
        Node existsNode = tab.get(node.key);
        if(existsNode != null){
            existsNode.value = node.value;
            linkedList.moveToHead(existsNode);
            return;
        }
        linkedList.addToHead(node);
        tab.put(node.key,node);
        if(capacity < tab.size()){
            //移除最后一个元素
            tab.remove(linkedList.tail.pre.key);
            linkedList.removeNode(linkedList.tail.pre);
        }
    }




    private class Node {

        private int key;

        private int value;

        private Node pre;

        private Node next;

        public Node(){

        }

        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    private class LinkedList{
        private Node head;
        private Node tail;

        public LinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }
        /**
         将该节点从队列中移除
         **/
        private void removeNode(Node node){
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        /**
         移动到队首
         **/
        private void moveToHead(Node node){
            removeNode(node);
            addToHead(node);
        }
        /**
         将该节点添加到队列的头部
         **/
        private void addToHead(Node node){
            node.pre = head;
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
