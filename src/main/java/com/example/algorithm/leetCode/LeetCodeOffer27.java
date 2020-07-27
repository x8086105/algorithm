package com.example.algorithm.leetCode;

public class LeetCodeOffer27 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    public static void main(String[] args) {

    }

    public static TreeNode mirrorTree(TreeNode root) {
        exchange(root);
        return root;
    }

    private static void exchange(TreeNode node) {
        if(node == null){
            return;
        }
        exchange(node.left);
        exchange(node.right);
        TreeNode node1 = node.left;
        node.left = node.right;
        node.right = node1;

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
