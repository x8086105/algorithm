package com.example.algorithm.leetCode;

import java.util.List;

public class LeetCode530 {
    private static Integer minVal = Integer.MAX_VALUE;
    private static Integer preValue = null;
    public static void main(String[] args) {
        TreeNode node = new TreeNode(236);
        node.left = new TreeNode(104);

        node.right = new TreeNode(701);
        node.left.right = new TreeNode(227);
        node.right.right = new TreeNode(911);

        int i =getMinimumDifference(node);
        System.out.println(i);
    }
    public static int getMinimumDifference(TreeNode root) {

        getMin(root);
        return minVal;
    }

    private static void getMin(TreeNode root){
        if(root == null){
            //中序遍历 从小到大排列 然后记录最小的差值
            return;
        }
        getMin(root.left);
        if (preValue != null) {
            minVal = Math.min(Math.abs(root.val - preValue), minVal);
        }
        preValue = root.val;
        getMin(root.right);
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
