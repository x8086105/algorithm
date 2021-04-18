package com.example.algorithm.leetCode;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * 102. 二叉树的层序遍历
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 * <p>
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层序遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class LeetCode102 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        //主要使用队列去存放，然后用list集合进行包裹起来
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        //通过层序遍历，获取路径
        levelOrder(root, result);
        return result;
    }

    private static void levelOrder(TreeNode root, List<List<Integer>> result) {
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> ls = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.removeFirst();
                ls.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(ls);
        }

    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        List<List<Integer>> relust = levelOrder(treeNode);
        System.out.println(relust);
    }
}
/**
 * 这道题其实做过很多，现在说一下这个题目的思路
 * 首先，肯定先判定这个顶头结点是否是空节点，如果是的话，就直接返回空集合
 * 然后使用队列，先进先出的特性，将头结点先加入到这个队列中，然后移除头结点
 * 的时候，顺便将它的左右孩子结点放到这个队列中，
 * 其中，需要进行路径的存储，那在每次便利的时候，就要获取队列的总长度，然后
 * 在比那里的过程中，将当前遍历的节点的值添加到集合中，每次遍历完成之后，加到路径的
 * 全集合中
 **/