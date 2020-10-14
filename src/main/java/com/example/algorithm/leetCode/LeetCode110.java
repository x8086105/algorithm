package com.example.algorithm.leetCode;

/**
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 */
public class LeetCode110 {

    public static void main(String[] args) {
       // [1,2,2,3,3,null,null,4,4]
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(2);
        node.left.left = new TreeNode(3);
        node.left.right = new TreeNode(3);
        node.left.left.left = new TreeNode(4);
        node.left.left.right = new TreeNode(4);

        boolean flag = isBalanced(node);
        System.out.println(flag);
    }


    public static boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        System.out.println(root.left.val + "：" + getHeight(root.left));
        System.out.println(root.right.val + "：" + getHeight(root.right));
        return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1 &&isBalanced(root.left) && isBalanced(root.right) ;
    }

    private static int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }

}
