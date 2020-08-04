package com.example.algorithm.leetCode;

import com.google.common.collect.Lists;

import java.util.LinkedList;
import java.util.List;

public class LeetCodeOffer34 {

    private static List<List<Integer>> restList = new LinkedList<>();
    private static  LinkedList<Integer> result = new LinkedList<>();

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);
        node.right = new TreeNode(8);
        node.right.right = new TreeNode(4);
        node.right.right.right= new TreeNode(1);
        node.right.left = new TreeNode(13);
        node.right.right.left = new TreeNode(5);
        pathSum(node,22);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root,22);
        return restList;
    }
    private static void recur(TreeNode node , int sum){
        if(node == null) return;
        result.add(node.val);
        sum -= node.val;
        if(sum == 0 && node.left == null && node.right == null)
            restList.add(new LinkedList<>(result));
        recur(node.left, sum);
        recur(node.right, sum);
        result.removeLast();

    }



    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
