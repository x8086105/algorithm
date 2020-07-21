package com.example.algorithm.leetCode;

import java.util.Stack;

public class LeetCodeOffer06 {

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        head1.next = head2;
        head2.next = head3;
        int [] ss = reversePrint(head1);
        for(int i = 0;i<ss.length;i++){
            System.out.println(ss[i]);
        }
    }

    public static int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.val);
            head = head.next;
        }
        int [] result = new int[stack.size()];
        int size = stack.size();
        for(int i = 0;i < size; i ++){
            result[i] = stack.pop();
        }
        return result;
    }

    public static class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }
}
