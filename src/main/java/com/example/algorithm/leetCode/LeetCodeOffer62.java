package com.example.algorithm.leetCode;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 */
public class LeetCodeOffer62 {

    public static void main(String[] args) {
        System.out.println(lastRemaining(5,3));
    }
    public static int lastRemaining(int n, int m) {
        //类似于循环链表，就是要用双指针，初始的时候，第一个指针指向0 第二个指针指向m之后的那个值
        //然后进行删除 并且记录，再将第一个指针移向需要删除的那个元素的后一个未被删除的元素
        return 0;
    }

}
