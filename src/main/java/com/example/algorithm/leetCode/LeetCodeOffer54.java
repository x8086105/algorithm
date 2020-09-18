package com.example.algorithm.leetCode;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 *
 *
 *
 * 示例 1:
 *
 * 输入: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * 输出: 4
 * 示例 2:
 *
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * 输出: 4
 * 反中序遍历
 * 中序遍历的顺序为 左根右
 * 反中序遍历则为 右根左
 */
public class LeetCodeOffer54 {
    public static void main(String[] args) {

    }

    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;

    }

    private void dfs(TreeNode root) {
        if(root == null){
            return;
        }
        dfs(root.right);
        if(k == 0){
            return;
        }
        k --;
        if(k == 0){
            res = root.val;
        }
        dfs(root.left);
    }

    public class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }


}
