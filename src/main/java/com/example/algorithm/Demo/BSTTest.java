package com.example.algorithm.Demo;

import com.example.algorithm.dataStructure.BST;

public class BSTTest {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        Integer []inter = {10,5,6,8,11,35,20,9,21};
        for(int i = 0;i<inter.length ;i++){
            bst.add(inter[i]);
        }
        bst.preTraversal();
        System.out.println("-------------");
        bst.midTraversal();
        System.out.println("-------------");
        bst.afterTraversal();
        System.out.println("-------------");
        bst.preTraversalWithoutRecursion();
        System.out.println("-------------");
        bst.breadthTraversal();
        System.out.println("-------------");
        bst.removeMin();
        bst.breadthTraversal();
        System.out.println("-------------");
        bst.removeMax();
        bst.breadthTraversal();
        System.out.println("-------------");
        System.out.println(bst.minimum());
        System.out.println("-------------");
        System.out.println(bst.maximum());
    }
}
