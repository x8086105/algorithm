package com.example.algorithm.leetCode.plus;

/**
 * 给定一个二叉树，其中所有的右节点要么是具有兄弟节点（拥有相同父节点的左节点）的叶节点，要么为空，将此二叉树上下翻转并将它变成一棵树，
 * 原来的右节点将转换成左叶节点。返回新的根。
 *
 * 例子:
 *
 * 输入: [1,2,3,4,5]
 *
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 *
 * 输出: 返回二叉树的根 [4,5,2,#,#,3,1]
 *
 *    4
 *   / \
 *  5   2
 *     / \
 *    3   1
 *
 */
public class LeetCode156 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        TreeNode result = upsideDownBinaryTree(root);
        System.out.println(result);

    }

    public static TreeNode upsideDownBinaryTree(TreeNode root) {
        return solution(root);
    }

    /**
     * 根据题意，可以得知一个很关键的因素，就是节点的左孩子节点是其右兄弟节点，节点的右孩子节点是其父节点
     * 然后只需要遍历每层的最左节点就可以了
     * @param root
     * @return
     */
    private static TreeNode solution(TreeNode root){
        TreeNode father = null;
        TreeNode right = null;
        while (root != null){
            TreeNode left = root.left;
            root.left = right;
            right = root.right;
            root.right = father;
            father = root;
            root = left;
        }
        return father;
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
