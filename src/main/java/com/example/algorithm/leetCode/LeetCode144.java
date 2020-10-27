package com.example.algorithm.leetCode;

import java.util.*;

/**
 * 144. 二叉树的前序遍历
 * 给定一个二叉树，返回它的 前序 遍历。
 *
 *  示例:
 *
 * 输入: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * 输出: [1,2,3]
 */
public class LeetCode144 {
    private static List<Integer> list = new ArrayList<>();
    public static void main(String []args){
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        traversal(root);
        System.out.println(list);
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root,list);
        return list;
    }

    /**
     * 递归遍历
     * @param root
     * @param list
     */
    private static void traversal(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        list.add(root.val);
        traversal(root.left,list);
        traversal(root.right,list);
    }

    /**
     * 通过队列实现前序遍历
     */
    private static void traversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        if(root == null){
            return;
        }
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode curNode  = stack.pop();

            list.add(curNode.val);
            if(curNode.right != null){
                stack.push(curNode.right);

            }
            if(curNode.left != null){
                stack.push(curNode.left);

            }

        }

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
