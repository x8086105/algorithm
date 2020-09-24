package com.example.algorithm.leetCode;

import sun.reflect.generics.tree.Tree;

public class LeetCode617 {
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);

        t1 = merge(t1,t2);
        System.out.println(t1);
    }

    private static TreeNode merge(TreeNode t1,TreeNode t2){
        if( t2 == null ){
            return t1;
        }
        if(t1 == null){
            return new TreeNode(t2.val);
        }else{
            t1.val = t1.val + t2.val;
        }
        t1.left = merge(t1.left,t2.left);
        t1.right = merge(t1.right,t2.right);
        return t1;
    }

    public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode(int x) { val = x; }
     }
}
