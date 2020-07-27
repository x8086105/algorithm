package com.example.algorithm.leetCode;

import org.apache.xmlbeans.impl.xb.xsdschema.BlockSet;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *给定一个链表: 1->2->3->4->5, 和 k = 2.
 *
 * 返回链表 4->5.
 *  
 * 双指针法
 * 一个指针先跑，跑的距离后面那个指针的间隔刚好是k然后两个以同样的速度跑
 * 前面那个指针跑完之后，就返回后面那个指针的next即可
 */
public class LeetCodeOffer22 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode ll = getKthFromEnd2(listNode,2);
        System.out.println(ll);
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        if( k == 0){
            return head;
        }
        ListNode preNode = head;
        ListNode afterNode = head;
        int start = 0;
        while (afterNode != null){
            if(start == k){
                preNode = preNode.next;
            }
            if(start < k){
                start ++;
            }
            afterNode = afterNode.next;
        }
        return preNode;
    }

    /**
     * LeetCode上的题解
     * @param head
     * @param k
     * @return
     */
    public static ListNode getKthFromEnd2(ListNode head, int k) {

        ListNode preNode = head;
        ListNode afterNode = head;
        int start = 0;
        for(int i = 0;i<k;i++){
            afterNode = afterNode.next;
        }
        while (afterNode != null){
            preNode = preNode.next;
            afterNode = afterNode.next;
        }
        return preNode;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public void testBag(){

    }

}
