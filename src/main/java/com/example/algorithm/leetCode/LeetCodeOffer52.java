package com.example.algorithm.leetCode;

public class LeetCodeOffer52 {
    /**
     * 双指针法，浪漫相遇
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aHead = headA;
        ListNode bHead = headB;
        while (aHead != bHead){

            aHead = aHead == null ? headB : aHead.next;
            bHead = bHead == null ? headA : bHead.next;
        }
        return aHead;
    }

    public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }
}
