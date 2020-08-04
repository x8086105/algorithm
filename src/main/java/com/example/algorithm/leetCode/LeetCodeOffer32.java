package com.example.algorithm.leetCode;

import com.google.common.collect.Lists;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LeetCodeOffer32 {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        //依然是层序遍历，不过要判断分层
        Deque<TreeNode> deque = new ArrayDeque<>();
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        deque.add(root);
        while (deque.size() > 0){
            List<Integer> tmp = new ArrayList<>();
            for(int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.poll();
                tmp.add(node.val);
                if(node.left != null) {
                    deque.add(node.left);
                }
                if(node.right != null) {
                    deque.add(node.right);
                }
            }
            lists.add(tmp);
        }
        return lists;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
