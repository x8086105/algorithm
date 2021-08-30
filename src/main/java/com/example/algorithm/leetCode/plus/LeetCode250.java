package com.example.algorithm.leetCode.plus;

/**
 * 给定一个二叉树，统计该二叉树数值相同的子树个数。
 *
 * 同值子树是指该子树的所有节点都拥有相同的数值。
 *
 * 示例：
 *
 * 输入: root = [5,1,5,5,5,null,5]
 *
 *               5
 *              / \
 *             1   5
 *            / \   \
 *           5   5   5
 *
 * 输出: 4
 *
 */
public class LeetCode250 {
    /**
     * 这道题题意不好理解，理解到尾就是叶子节点和完整的一棵树
     * @param root
     * @return
     */
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null) return 0;
        if(judge(root)) return countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right) + 1;
        else {
            return countUnivalSubtrees(root.left) + countUnivalSubtrees(root.right);
        }
    }
    public boolean judge(TreeNode root){
        if(root == null) return true;
        if(root.left!=null){
            if(root.left.val != root.val) return false;
        }
        if(root.right!=null){
            if(root.right.val != root.val) return false;
        }
        return judge(root.left) && judge(root.right);
    }
    public class TreeNode {
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
