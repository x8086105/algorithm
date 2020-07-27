package com.example.algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeOffer26 {

    public static void main(String[] args) {
        TreeNode A = new TreeNode(1);
        TreeNode B = new TreeNode(1);
        System.out.println(isSubStructure(A,B));
    }
    public static boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    static boolean recur(TreeNode A, TreeNode B) {
        if(B == null) return true;
        if(A == null || A.val != B.val) return false;
        return recur(A.left, B.left) && recur(A.right, B.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
