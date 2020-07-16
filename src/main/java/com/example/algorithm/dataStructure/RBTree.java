package com.example.algorithm.dataStructure;

/**
 * 红黑树
 */
public class RBTree<K extends Comparable<K>,V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{
        private Node left,right;
        private K key;
        private V value;
        private boolean color;

        public Node(K key,V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color = RED;
        }
    }

    private Node root;
    private int size;

    public RBTree(){
        root = null;
        size = 0;
    }

    private boolean isRed(Node node){
        if(node == null){
            return BLACK;
        }
        return node.color;
    }
}
