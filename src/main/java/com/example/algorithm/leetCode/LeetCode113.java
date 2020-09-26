package com.example.algorithm.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 */
public class LeetCode113 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
       List<List<Integer>>  re = pathSum(root,22);

        System.out.println(re);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> items = new ArrayList<>();
//        path(result,items,root,0,sum);
//        return result;
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, sum, new ArrayList<>(), result);
        return result;
    }

    public static void path(List<List<Integer>> list, List<Integer> items,TreeNode root,int curSum,int sum){
        if(root == null){
            return;
        }
        curSum += root.val;

        items.add(root.val);
        if(curSum == sum){
            list.add(new ArrayList<>(items));
        }
        path(list,items,root.left,curSum,sum);
        path(list,items,root.right,curSum,sum);
        items.remove(items.size() - 1);


    }

    public static void dfs(TreeNode root, int sum, List<Integer> list,
                    List<List<Integer>> result) {
        //如果节点为空直接返回
        if (root == null)
            return;
        //把当前节点值加入到subList中
        list.add(root.val);
        //如果到达叶子节点，就不能往下走了，直接return
        if (root.left == null && root.right == null) {
            //如果到达叶子节点，并且sum等于叶子节点的值，说明我们找到了一组，
            //要把它放到result中
            if (sum == root.val)
                result.add(new ArrayList<>(list));
            //到叶子节点之后直接返回，因为在往下就走不动了
            list.remove(list.size() - 1);
            return;
        }
        //如果没到达叶子节点，就继续从他的左右两个子节点往下找，注意到
        //下一步的时候，sum值要减去当前节点的值
        dfs(root.left, sum - root.val, list, result);
        dfs(root.right, sum - root.val, list, result);
        list.remove(list.size() - 1);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
