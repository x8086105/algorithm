package com.example.algorithm.leetCode;

/**
 * 538. 把二叉搜索树转换为累加树
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)
 * ，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 */
public class LeetCode538 {

    static int addValue = 0;

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(0);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(-4);
        node.left.right = new TreeNode(1);
        TreeNode root = convertBST(node);
        System.out.println(root);

    }

    public static TreeNode convertBST(TreeNode root) {
        //先遍历右边的值
        cal(root);
        return root;
    }

    private static void cal(TreeNode root) {
        if(root == null ){
            return;
        }
        cal(root.right);
        addValue += root.val;
        root.val = addValue;
        cal(root.left);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}

