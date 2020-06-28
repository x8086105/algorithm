package com.example.algorithm.dataStructure;

/**
 * 二分搜索树 的类
 * @param <E>
 */
public class BST<E extends Comparable<E>> {

    private class Node<E>{
        private E e;
        private Node left,right;

        public Node(E e){
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    /**
     * 根节点
     */
    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
        root = add(root,e);
    }

    /**
     * 给二叉树添加一个元素，返回根节点
     * 整体返回所有的根节点，如果根节点为null
     * 则new一个节点出来并且返回
     * @param node
     * @param e
     * @return
     */
    private Node add(Node<E> node, E e) {
        if(node == null){
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e)<0){
            node.left = add(node.left,e);
        }else if (e.compareTo(node.e)>0){
            node.right = add(node.right,e);
        }
        return node;
    }

    /**
     * 比较是否存在一个元素
     * @param e
     * @return
     */
    public boolean contains(E e){
        return contains(root,e);
    }

    private boolean contains(Node<E> root, E e) {
        if(root == null){
            return false;
        }
        if(e.equals(root.e)){
            return true;
        }else if(e.compareTo(root.e)<0){
            return contains(root.left,e);
        }else {
            return contains(root.right,e);
        }
    }
    /**
     * 前序遍历
     */
    public void preTraversal(){
        this.preTraversal(root);
    }

    private void preTraversal(Node root) {
        if(root == null){
            return;
        }
        System.out.println(root.e);
        this.preTraversal(root.left);
        this.preTraversal(root.right);
    }

    /**
     * 中序遍历
     */
    public void midTraversal(){
        this.midTraversal(root);
    }

    private void midTraversal(Node root) {
        if(root == null){
            return;
        }
         this.midTraversal(root.left);
        System.out.println(root.e);
         this.midTraversal(root.right);
    }

    /**
     * 后序遍历
     */
    public void afterTraversal(){
        this.afterTraversal(root);
    }

    private void afterTraversal(Node root) {
        if(root == null){
            return ;
        }
        this.midTraversal(root.left);
        this.midTraversal(root.right);
        System.out.println(root.e);
    }
}
