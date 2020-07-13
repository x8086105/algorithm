package com.example.algorithm.dataStructure;

import java.util.ArrayList;

/**
 * 基于二分搜索树的Map
 * @param <K>
 * @param <V>
 */
public class AVLTree<K extends Comparable<K>,V> implements Map<K,V>{
    private class Node{
        public K key;
        public V value;
        public Node left,right;
        //该节点的高度
        public int height;

        public Node(K k,V v){
            this.key = k;
            this.value = v;
            left = null;
            right = null;
            height = 1;
        }
    }
    private Node root;
    private int size;

    public AVLTree(){
        root = null;
        size = 0;
    }

    /**
     * 获得一个节点的高度
     * @param node
     * @return
     */
    private int getHeight(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
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
        //对当前node 的高度值进行更新
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        //计算当前节点的平衡因子
        int balanceFactor = getBalanceFactor(node);
        //LL模式
        if(balanceFactor > 1 && getBalanceFactor(node.left) >= 0){
            //此时该树不是平衡二叉树 并且倾向于左边，所以要进行右旋转
            return rightRotate(node);
        }
        //RR模式
        if(balanceFactor < -1 && getBalanceFactor(node.right) <= 0){
            return leftRotate(node);
        }
        //LR模式 首先不平衡，其次左子树的高度小于右子树的高度，证明新添加的节点
        //在整棵树的左子树上，其叶子落进了右子树上
        if(balanceFactor > 1 && getBalanceFactor(node.left) < 0 ){
            //处理方式先左旋转 再右旋转
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if(balanceFactor < -1 && getBalanceFactor(node.right) > 0 ){
            //处理方式先左旋转 再右旋转
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    /**
     * 进行右旋转，返回旋转之后平衡的根节点
     * @param y
     * @return
     * 始终满足的条件为  T1<z<T2<x<T3<y<T4
     *          y                                       x
     *         / \                                   /     \
     *        x   T4                                z       y
     *       / \               ----------->       /   \    /  \
     *      z   T3                              T1     T2 T3   T4
     *     / \
     *    T1  T2
     *
     */
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;

        x.right = y;
        y.left = T3;

        //更新高度值
        //从上图可以看出 需要更新的只有x y的两个高度值
        //首先，先更新y的高度值，再更新x的高度值
        y.height = Math.max(getHeight(y.left),getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.right),getHeight(x.left)) + 1;
        return x;
    }

    /**
     * 进行左旋转
     * 始终满足的条件为  T1<z<T2<x<T3<y<T4
     *          y                                       x
     *         / \                                   /     \
     *        T1   x                                y       z
     *            / \          ----------->       /   \    /  \
     *           T2  z                          T1     T2 T3   T4
     *              / \
     *             T3  T4
     * @param y
     * @return
     */
    private Node leftRotate(Node y){
        Node x = y.right;
        Node T2 = x . left;

        x.left = y;
        y.right = T2;

        //更新高度值
        //从上图可以看出 需要更新的只有x y的两个高度值
        //首先，先更新y的高度值，再更新x的高度值
        y.height = Math.max(getHeight(y.left),getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.right),getHeight(x.left)) + 1;
        return x;
    }

    /**
     * 获取一个node的平衡因子

     * @param node
     * @return
     */
    private int getBalanceFactor(Node node){
        if(node == null){
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    /**
     * 判断一棵树是否是二分搜索树
     * 中序遍历 放到一个集合中，然后判断集合是否是一个升序的集合
     * 即可
     * @return
     */
    private boolean isBST(){
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root,keys);
        //遍历keys 判断是否是一个升序的数组
        for(int i = 1; i < keys.size();i++){
            if(keys.get(i).compareTo( keys.get(i - 1)) < 0){
                return false;
            }
        }
        return true;
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if(node == null){
            return;
        }
        inOrder(node.left,keys);
        keys.add(node.key);
        inOrder(node.right,keys);
    }

    /**
     * 判断当前树是不是一个平衡二叉树
     * 定义：任意一个节点的左右子树的高度差不能超过1
     * @return
     */
    public boolean isBalanced(){
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if(node == null){
            return true;
        }
        int balanceFactory = getBalanceFactor(node);
        if(Math.abs(balanceFactory) > 1){
            return false;
        }
        return isBalanced(node.right) && isBalanced(node.left);

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
        System.out.println("key:" + root.key + "; value: " + root.value);
        this.preTraversal(root.left);
        this.preTraversal(root.right);
    }


}
