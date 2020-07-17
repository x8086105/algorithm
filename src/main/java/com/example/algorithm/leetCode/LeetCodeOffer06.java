package com.example.algorithm.leetCode;

public class LeetCodeOffer06 {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        head1.next = head2;
        head2.next = head3;
        int [] ss = reversePrint(head1);
    }

    public static int[] reversePrint(ListNode head) {
//        ListNode listNode;
//        ListNode c = head;
//        while (c.next != null){
//            c = c.next;
//            listNode = head.next;
//            head.next = null;
//            ListNode cur = listNode;
//            while (true){
//                if (cur.next == null){
//                    ListNode addNode = new ListNode(cur.val);
//
//                    break;
//                }
//
//            }
//        }

        return null;
    }

    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
}
