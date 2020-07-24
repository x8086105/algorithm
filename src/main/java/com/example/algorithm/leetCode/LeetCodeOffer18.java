package com.example.algorithm.leetCode;

public class LeetCodeOffer18 {
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(9);
        node.next.next.next.next = new ListNode(10);
        //ListNode nn = deleteNode(node,1);
        ListNode nn2 = deleteNode2(node,5);
        System.out.println(nn2);
    }
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    //方法1 设置虚拟头结点
    public static ListNode deleteNode(ListNode head, int val) {
       ListNode dummyHead = new ListNode(0);
       dummyHead.next = head;
       head = dummyHead;
       while (dummyHead.next != null){
           if(dummyHead.next.val == val){
               dummyHead.next = dummyHead.next.next;
               return head.next;
           }
           dummyHead = dummyHead.next;
       }
       return head.next;
    }
    //方法二，双指针
    public static ListNode deleteNode2(ListNode head, int val) {
        if(head.val == val){
            return head.next;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur != null && cur.val != val) {
            pre = cur;
            cur = cur.next;
        }
        if(cur != null){
            pre.next = cur.next;
        }
        return head;
    }
     private static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
}
