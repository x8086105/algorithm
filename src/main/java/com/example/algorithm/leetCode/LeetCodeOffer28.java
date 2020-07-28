package com.example.algorithm.leetCode;

import org.apache.poi.hssf.util.HSSFColor;

import java.util.*;

public class LeetCodeOffer28 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(3);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
       // node.right.left = new TreeNode(null);
        node.right.right = new TreeNode(4);
        System.out.println(isSymmetric(node));
    }

    public static boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        //进行层序遍历，通过栈的层序遍历 判断
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        //对左子树进行层序遍历 从左往右
        //对右子树进行层序遍历，从右往左
        List<Integer> leftlist = new ArrayList<>();
        trayTree(leftNode,leftlist,true);
        List<Integer> rightlist = new ArrayList<>();
        trayTree(rightNode,rightlist,false);
        if(leftlist.equals(rightlist)){
            return true;
        }
        return false;

    }

    private static void trayTree(TreeNode node, List<Integer> list,boolean isLeft) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(node == null){
            return;
        }
        queue.add(node);
        while (queue.size() > 0){
            TreeNode curNode = queue.poll();
            list.add(curNode == null ? null : curNode.val);
            //将其左右结点追加到后面
            if(curNode == null ){
                continue;
            }
            if(isLeft){
                queue.add(curNode.left);
                queue.add(curNode.right);

            }else{
                queue.add(curNode.right);
                queue.add(curNode.left);

            }

        }

    }

    /**
     * 官方题解
     * 使用递归方法，判断左子树的左孩子跟右子树的右孩子是否一致
     * 再判断左子树的右孩子跟右子树的子孩子是否一致
     * 返回两者的 并集关系
     * @param root
     * @return
     */
    public static boolean isSymmetric2(TreeNode root) {
        if(root == null){
            return true;
        }
        //进行层序遍历，通过栈的层序遍历 判断
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        return  isMirror(leftNode,rightNode);

    }
    private static boolean isMirror(TreeNode l,TreeNode r){
        if(l == null && r == null) {
            return true;
        }
        if(l == null || r == null || l.val != r.val){
            return false;
        }
        return isMirror(l.left,r.right) && isMirror(l.right,r.left);

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
