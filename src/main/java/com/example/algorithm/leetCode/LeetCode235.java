package com.example.algorithm.leetCode;

import com.example.algorithm.dataStructure.ArrayStack;
import com.example.algorithm.dataStructure.Stack;
import sun.reflect.generics.tree.Tree;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]
 *
 *
 *
 *  
 *
 * 示例 1:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * 输出: 6
 * 解释: 节点 2 和节点 8 的最近公共祖先是 6。
 * 示例 2:
 *
 * 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * 输出: 2
 * 解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。
 *
 */
public class LeetCode235 {
    private static TreeNode maxTreeNode = null;
    private static boolean flag = false;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.left = null;
        root.left.right = new TreeNode(2);
//        root.left.right.left = new TreeNode(3);
//        root.left.right.right = new TreeNode(5);

        root.right = new TreeNode(4);
//        root.right.left = new TreeNode(7);
//        root.right.right = new TreeNode(9);

        lowestCommonAncestor(root,new TreeNode(2),new TreeNode(4));
        System.out.println(maxTreeNode);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) {
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;

    }


    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
