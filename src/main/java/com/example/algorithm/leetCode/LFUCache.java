package com.example.algorithm.leetCode;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {
    /**
     *     存储缓存的内容
     */
    Map<Integer, Node> cache;
    /**
     * 存储每个频次对应的双向链表
     */
    Map<Integer, LinkedList> freqMap;

    int size;

    int capacity;
    /**
     * 存储当前最小频次
     */
    int min;

    public LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        freqInc(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            freqInc(node);
        } else {
            if (size == capacity) {
                LinkedList minFreqLinkedList = freqMap.get(min);
                cache.remove(minFreqLinkedList.tail.pre.key);
                // 这里不需要维护min, 因为下面add了newNode后min肯定是1.
                minFreqLinkedList.removeNode(minFreqLinkedList.tail.pre);
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            LinkedList linkedList = freqMap.get(1);
            if (linkedList == null) {
                linkedList = new LinkedList();
                freqMap.put(1, linkedList);
            }
            linkedList.addNode(newNode);
            size++;
            min = 1;
        }
    }

    void freqInc(Node node) {
        // 从原freq对应的链表里移除, 并更新min
        int freq = node.freq;
        LinkedList linkedList = freqMap.get(freq);
        linkedList.removeNode(node);
        if (freq == min && linkedList.head.next == linkedList.tail) {
            min = freq + 1;
        }
        // 加入新freq对应的链表
        node.freq++;
        linkedList = freqMap.get(freq + 1);
        if (linkedList == null) {
            linkedList = new LinkedList();
            freqMap.put(freq + 1, linkedList);
        }
        linkedList.addNode(node);
    }

    class Node {
        int key;
        int value;
        int freq = 1;
        Node pre;
        Node next;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class LinkedList {
        Node head;
        Node tail;

        public LinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.pre = head;
        }

        void removeNode(Node node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        void addNode(Node node) {
            node.next = head.next;
            head.next.pre = node;
            head.next = node;
            node.pre = head;
        }
    }

}
