package com.example.algorithm.leetCode;

/**
 * 实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
 *
 * 注意：本题相对原题稍作改动
 *
 * 示例：
 *
 * 输入： 1->2->3->4->5 和 k = 2
 * 输出： 4
 *
 */
public class LeetCode02_02 {

    public static void main(String[] args) {

    }
    public static int kthToLast(ListNode head, int k) {
        //采用双指针， 第一个指针指向头，第二个指针指向这个头的后K个然后一起移动，直到第二个指针指向尾部的话 返回第一个指针指向的那个节点的值即可 时间复杂度为O(n) 空间复杂度为O(1)
        ListNode pre = head;
        ListNode later = head;
        int i = 0;
        while (later != null) {
            if (i < k) {
                i++;
            } else {
                pre = pre.next;
            }
            later = later.next;
        }
        if (i == k) {
            return pre.val;
        }
        return -1;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
