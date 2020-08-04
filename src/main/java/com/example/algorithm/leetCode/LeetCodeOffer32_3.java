package com.example.algorithm.leetCode;

import java.util.*;

public class LeetCodeOffer32_3 {
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        System.out.println(levelOrder(treeNode));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        //依然是层序遍历，不过要判断分层
        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        deque.add(root);
        while (deque.size() > 0) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = deque.size(); i > 0; i--) {
                TreeNode node = deque.poll();
                if (lists.size() % 2 == 0) {
                    tmp.addLast(node.val);
                } else {
                    tmp.addFirst(node.val);
                }

                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
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

        TreeNode(int x) {
            val = x;
        }
    }
}
