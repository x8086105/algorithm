package com.example.algorithm.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class NiuKeLRUCache {


    public static int[] LRU (int[][] operators, int k) {
        initLRU(k);
        // write code here
        int length = operators.length;
        List<Integer> res = new ArrayList<>();  // 返回的结果
        for(int i = 0; i < length; ++i){
            int key = operators[i][1];
            if (operators[i][0] == 1) {
                ListNode newNode = new ListNode(operators[i][1],operators[i][2]);
                addNode(newNode);
            }else{
                int n = getNode(operators[i][1]);
                res.add(n);
            }
        }
        int [] arr = new int[res.size()];
        for(int i = 0;i<res.size();i++){
            arr[i]=res.get(i);
        }
        return arr;
    }


    private static void removeNode(ListNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private static void addToHead(ListNode node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private static void addNode(ListNode node){
        ListNode existsNode = tab.get(node.key);
        if(existsNode != null){
            existsNode.value = node.value;
            moveToHead(existsNode);
            return;
        }
        addToHead(node);
        tab.put(node.key,node);
        if(size < tab.size()){
            //移除最后一个元素
            tab.remove(tail.pre.key);
            removeNode(tail.pre);
        }
    }

    private static int getNode(int key){
        ListNode n = tab.get(key);
        if(n == null){
            return -1;
        }
        moveToHead(n);
        return n.value;
    }

    private static void moveToHead(ListNode node) {
        removeNode(node);
        addToHead(node);
    }

    private static void initLRU(int k){
        head.next = tail;
        tail.pre = head;
        size = k;
        tab = new HashMap<Integer,ListNode>(size);
    }

    private static int size;

    private static ListNode head = new ListNode(-1,-1);

    private static ListNode tail = new ListNode(-1,-1);

    private static class ListNode {
        private int key;
        private int value;
        private ListNode next;
        private ListNode pre;

        public ListNode(int key,int value){
            this.key = key;
            this.value = value;
        }

    }

    private static HashMap<Integer,ListNode> tab;


    public static void main(String[] args) {
        int s[][] = { {1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}};
        int size = 3;
        int []resut = LRU(s,size);
        System.out.println(resut);
    }
}
