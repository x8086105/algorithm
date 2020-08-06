package com.example.algorithm.Demo;

import com.example.algorithm.dataStructure.AVLTree;
import com.example.algorithm.dataStructure.Set;

import java.util.HashSet;

/**
 * AVL树的测试
 * 为了让整棵树保持平衡
 */
public class AVLTreeDemo {
    public static void main(String[] args) {
        AVLTree<Integer,Integer> avlTree = new AVLTree<>();
        for(int i = 0;i<10;i++){
            avlTree.add(i,i);
        }
        avlTree.preTraversal();
    }
}
