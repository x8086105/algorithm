package com.example.algorithm.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 *
 * 假定 BST 有如下定义：
 *
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 * 返回[2].
 *
 * 提示：如果众数超过1个，不需考虑输出顺序
 *
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 *
 */
public class LeetCode501 {

    static List<Integer> mList = new ArrayList<>();
    static int curent = 0;//表示当前节点的值
    static int count = 0;//表示当前节点的数量
    static int maxCount = 0;//最大的重复数量

    public static void main(String[] args) {

    }

    public static int[] findMode(TreeNode root) {
        if(root == null){
            return null;
        }
        dfs(root);
        int []result = new int[mList.size()];
        for(int i = 0;i<mList.size(); i++){
            result[i] = mList.get(i);
        }
        return result;
    }


    private static void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        int nodeValue = node.val;
        if (nodeValue == curent) {
            //如果节点值等于curent，count就加1
            count++;
        } else {
            //否则，就表示遇到了一个新的值，curent和count都要
            //重新赋值
            curent = nodeValue;
            count = 1;
        }
        if (count == maxCount) {
            //如果count == maxCount，就把当前节点加入到集合中
            mList.add(nodeValue);
        } else if (count > maxCount) {
            //否则，当前节点的值重复量是最多的，直接把list清空，然后
            //把当前节点的值加入到集合中
            mList.clear();
            mList.add(nodeValue);
            maxCount = count;
        }

        dfs(node.right);
    }

    public static class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
   }
}
