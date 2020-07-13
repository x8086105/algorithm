package com.example.algorithm.dataStructure;

/**
 * 基于二分搜索树的Map
 * @param <K>
 * @param <V>
 */
public class BSTMap<K extends Comparable<K>,V> implements Map<K,V>{
    private class Node{
        public K key;
        public V value;
        public Node left,right;
        public Node(K k,V v){
            this.key = k;
            this.value = v;
            left = null;
            right = null;
        }
    }
    private Node root;
    private int size;

    public BSTMap(){
        root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root,key,value);
    }

    private Node add(Node node, K key, V value) {
        if(node == null){
            size ++ ;
            return new Node(key,value);
        }
        if(node.key.compareTo(key) > 0){
            //添加到右边
            node.left = add(node.left,key,value);
        }else if(node.key.compareTo(key) < 0){
            node.right = add(node.right,key,value);
        }else{
            //key.compareTo(node.key) == 0
            node.value = value;
        }

        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root,key);
        if(node != null){

            return remove(root,key).value;
        }
        return null;
    }

    private Node remove(Node node, K key) {
        if(node == null){
            return null;
        }
        if(node.key.compareTo(key) > 0){
            //从左边进行移除
            node.left = remove(node.left,key);
            return node;
        }else if(node.key.compareTo(key) < 0){
            node.right = remove(node.right,key);
            return node;
        }else{
            //待删除的节点，左子树为null的情况
            if(node.left == null){
                //直接将右子树接上去就行
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            //找到前驱节点
            Node successor = maximum(node.left);
            successor.left = removeMax(node.left);
            successor.right = node.right;
            node.right = node.left = null;
            return successor;

        }

    }
    public Node removeMax(){
        Node maxmum = this.maximum();
        root = this.removeMax(root);
        return maxmum;
    }

    public Node removeMin(){
        Node minimum = this.minimum();
        root = this.removeMin(root);
        return minimum;
    }

    private Node removeMin(Node node) {
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除掉最大的元素
     * @param node
     * @return
     */
    private Node removeMax(Node node) {
        if(node.right == null){
            //将当前节点的左孩子赋值给当前值，然后在断绝关系
            Node leftNode = node.left;
            node.left = null;
            size -- ;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public Node minimum(){
        if(size == 0){
            return null;
        }
        return minimum(root);
    }
    private Node minimum(Node root) {
        if(root.left == null){
            return root;
        }
        return minimum(root.left);
    }

    public Node maximum(){
        if(size == 0){
            return null;
        }
        return maximum(root);
    }
    private Node maximum(Node root) {
        if(root.right == null){
            return root;
        }
        return maximum(root.right);
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null;
    }

    @Override
    public V get(K key) {
       Node node = getNode(root,key);
       return node == null ? null : node.value;
    }

    private Node getNode(Node node,K key){
        if(node == null){
            return  null;
        }
        if(node.key.compareTo(key) > 0){
            //从左边进行移除
            return getNode(node.left,key);
        }else if(node.key.compareTo(key) < 0){
            return getNode(node.right,key);
        }else{
            return node;
        }

    }
    @Override
    public void set(K key, V value) {
        Node node = getNode(root,key);
        if(node == null){
            throw new IllegalArgumentException(key +" doesn't exists!");
        }
        node.value = value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
