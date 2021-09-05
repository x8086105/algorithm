package com.example.algorithm.leetCode.plus;

/**
 * 255. 验证前序遍历序列二叉搜索树
 * 给定一个整数数组，你需要验证它是否是一个二叉搜索树正确的先序遍历序列。
 *
 * 你可以假定该序列中的数都是不相同的。
 *
 * 参考以下这颗二叉搜索树：
 *
 *      5
 *     / \
 *    2   6
 *   / \
 *  1   3
 * 示例 1：
 *
 * 输入: [5,2,6,1,3]
 * 输出: false
 * 示例 2：
 *
 * 输入: [5,2,1,3,6]
 * 输出: true
 */
public class LeetCode255 {



    public boolean verifyPreorder(int[] preorder) {
        //二叉搜索树的前序遍历先左再右，内涵就是左子树小于根节点。
        //使用单调栈，每次遇到比栈顶元素大的，就移除
        int length = preorder.length;
        int []stack = new int[length];
        int top = -1;
        int min = Integer.MAX_VALUE;
        for (int per : preorder){
            if(per > min){
                return false;
            }
            while (top != -1 && stack[top] < per){
                min = stack[top];
                top--;
            }
            stack[++top] = per;
        }
        return true;
    }

}
