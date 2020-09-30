package com.example.algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 *
 * 例如，给定一个 3叉树 :
 *            1
 *           / \ \
 *          3   2 4
 *         / \
 *        5   6
 *
 *
 * 返回其前序遍历: [1,3,5,6,2,4]。
 */
public class LeetCode589 {


    public static void main(String[] args) {

    }
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        pre(root,list);
        return list;
    }

    private void pre(Node root, List<Integer> list) {
        if(root == null){
            return;
        }
        list.add(root.val);
        if(root.children != null){
            for (Node node: root.children) {
                pre(node,list);
            }
        }
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
}
