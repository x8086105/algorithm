package com.example.algorithm.leetCode;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且
 * x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 * <p>
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 */
public class LeetCode236 {


    private static TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     使用栈来存储路径
     */
    private static TreeNode low2(TreeNode root,TreeNode p, TreeNode q){
            //用来存放p节点的路径
            List<TreeNode> pPath = new ArrayList<>();
            //用来存放q节点的路径
            List<TreeNode> qPath = new ArrayList<>();
            //走过的路径
            List<TreeNode> path = new ArrayList<>();
            int finish  = 0;
            DFS(root,p,path,pPath,finish);
            finish = 0;
            path = new LinkedList<>();
            DFS(root,q,path,qPath,finish);
            //这里找到路径之后，就进行遍历，
            TreeNode result = null;
            int length = Math.min(pPath.size(),qPath.size());
            for(int i = 0;i < length;i++){
                TreeNode pNode = pPath.get(i);
                TreeNode qNode = qPath.get(i);
                if(pNode == qNode){
                    result = pNode;
                }else {
                    break;
                }
            }

            return result;

    }
    //在节点root中寻找p节点的路径
    private static void DFS(TreeNode root, TreeNode p,List<TreeNode> path, List<TreeNode> result,int finish){
        if(root == null || finish == 1){
            return;
        }
        path.add(root);
        //代表找到了
        if(root == p){
            finish = 1;
            result.addAll(path);
        }
        DFS(root.left,p,path,result,finish);
        DFS(root.right,p,path,result,finish);
        path.remove(path.size() - 1);
    }
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(5);
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.right.left = new TreeNode(7);
        treeNode.left.right.right = new TreeNode(4);
        treeNode.right = new TreeNode(1);
        treeNode.right.right = new TreeNode(8);
        treeNode.right.left = new TreeNode(0);

        TreeNode n = low2(treeNode,treeNode.left,treeNode.left.right.right);
        System.out.println(n);
//
//        LinkedList<Integer> s  = new LinkedList<>();
//        s.push(1);
//        s.push(2);
//
//        LinkedList<Integer> s2 = new LinkedList<>(s);
//        s.pop();
//        s.pop();
//        System.out.println(s2.size());

    }
}
