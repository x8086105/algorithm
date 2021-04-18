package com.example.algorithm.leetCode;

public class LeetCodeDeleteListNode {
      public static class ListNode {
          int val;
          ListNode next;
          ListNode() { }
          ListNode(int x) { val = x; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = new ListNode();
        pre.next = head;
        while(head != null){
            ListNode after = head.next;
            head.next = pre;
            pre = head;
            head = after;
        }
        return pre;
    }
    public static void main(String[] args) {
        ListNode node = new ListNode(4);
        node.next = new ListNode(5);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(9);
        ListNode delNode = new ListNode(5);

        ListNode result =  reverseList(node);
        System.out.println(result);

    }
}
