package com.example.algorithm.Demo;

public class ListDemo {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        // 1->2->3->4
        ListNode result = solution(head);
        System.out.println(result);
    }

    private static ListNode solution(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
    private static class ListNode{
        private int val;
        private ListNode next;
        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val,ListNode next){
            this.val = val;
            this.next = next;
        }
        public ListNode(){};
    }

}


