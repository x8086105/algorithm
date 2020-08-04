package com.example.algorithm.leetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCodeOffer35 {

    public static void main(String[] args) {
        Node node = new Node(7);
        node.next = new Node(13);
        node.next.next = new Node(11);
        node.next.next.next = new Node(10);
        node.next.next.next.next = new Node(1);
        node.random = null;
        node.next.random = node;
        node.next.next.random = node.next.next.next.next ;
        node.next.next.next.random = node.next.next;
        node.next.next.next.next.random = node;
        Node copNode = copyRandomList(node);
        System.out.println(copNode);
    }

    public static Node copyRandomList(Node head) {
        Node copNode = new Node(0);
        Node pre = copNode;
        Node cHead1 = head;
        Map<Node,Node> cNode2RandNode = new HashMap<>();
        while (cHead1 != null){
            pre.next = new Node(cHead1.val);
            pre = pre.next;
            cNode2RandNode.put(cHead1,pre);
            cHead1 = cHead1.next;
        }

        pre = copNode;
        cHead1 = head;
        while (cHead1 != null){
            Node randonNode = cHead1.random == null? null : cNode2RandNode.get(cHead1.random);
            pre.next.random = randonNode;
            pre = pre.next;
            cHead1 = cHead1.next;
        }

        return copNode.next;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
