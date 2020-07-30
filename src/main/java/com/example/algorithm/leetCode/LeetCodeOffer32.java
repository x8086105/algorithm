package com.example.algorithm.leetCode;

import javax.xml.bind.annotation.XmlType;
import java.util.*;

public class LeetCodeOffer32 {


    public static void main(String[] args) {

    }
    public int[] levelOrder(TreeNode root) {
        //借助队列 完成层序遍历
        if(root == null){
            return new int[0];
        }
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        List<Integer> list = new ArrayList<>();
        while (! deque.isEmpty()){
            TreeNode node = deque.pop();
            list.add(node.val);
            if(node.left != null){
                deque.add(node.left);
            }
            if(node.right != null){
                deque.add(node.right);
            }
        }
        int [] s = new int[list.size()];
        for(int i = 0;i<list.size();i++){
            s[i]=list.get(i);
        }
        return s;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
