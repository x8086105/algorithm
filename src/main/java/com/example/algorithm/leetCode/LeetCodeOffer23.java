package com.example.algorithm.leetCode;

import java.util.List;

public class LeetCodeOffer23 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(1);
        l1.next.next = new ListNode(1);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = mergeTwoLists(l1,l2);
        System.out.println(l3);
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(-1);
        ListNode temp = l3;
        while (l1 != null || l2 != null){
            if(l1 == null){
                temp.next = l2;
                return l3.next;
            }
            if(l2 == null){
                temp.next = l1;
                return l3.next;
            }
            if(l1.val <= l2.val){
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
                continue;
            }
            temp.next = l2;
            temp = temp.next;
            l2 = l2.next;
            continue;
        }
        return l3.next;
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

}
