package com.example.algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
 * <p>
 * 如果链表中存在环，则返回 true 。 否则，返回 false 。
 */
public class LeetCode141 {

    public boolean hasCycle(ListNode head) {
        //第一次想到的是快慢指针如果有环的话 两个指针一定能够相遇
        ListNode pre = head;
        if(pre == null || pre.next == null){
            return false;
        }
        ListNode after = pre.next;

        while (after != null && after.next != null && pre != after){
            pre = pre.next;
            after = after.next.next;
        }
        if(after == null || after.next != null){
            return false;
        }
        return true;
    }


   private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
