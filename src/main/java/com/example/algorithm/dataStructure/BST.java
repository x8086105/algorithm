package com.example.algorithm.dataStructure;

/**
 * 二分搜索树 的类
 * @param <E>
 */
public class BST<E extends Comparable<E>> {
    /**
     * 内部类 节点
     * @param <E>
     */
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

    /**
     * 非递归的前序遍历
     */
    public void preTraversalWithoutRecursion(){
        this.preTraversalWithoutRecursion(root);
    }

    /**
     * 借助栈的功能，通过将元素一次放进栈中 每次拿出来的时候再将元素的
     * 右孩子，左孩子再次拿出来放到栈顶。依次循环即可
     * @param root
     */
    private void preTraversalWithoutRecursion(Node root) {
        Stack<Node> stack = new ArrayStack<>();
        stack.push(root);
        while (! stack.isEmpty()){
            Node ce = stack.pop();
            System.out.println(ce.e);
            if(ce.right != null){
                stack.push(ce.right);
            }
            if(ce.left != null){
                stack.push(ce.left);
            }
        }
    }

    /**
     * 广度优先遍历
     * 层序遍历
     */
    public void breadthTraversal(){
        this.breadthTraversal(root);
    }

    /**
     * 层序遍历，广度优先遍历，需要依赖
     * @param root
     */
    private void breadthTraversal(Node root) {
        Queue<Node> queue = new LoopQueue<>();
        queue.enqueue(root);
        while (! queue.isEmpty()){
            Node cNode = queue.dequeue();
            System.out.println(cNode.e);
            if(cNode.left != null){
                queue.enqueue(cNode.left);
            }

            if(cNode.right != null) {
                queue.enqueue(cNode.right);
            }
        }
    }

    public E removeMin(){
        E ret = this.minimum();
        root = this.removeMin(root);
        return ret;
    }

    /**
     * 删除掉左
     * @param node
     * @return
     */
    private Node removeMin(Node node) {
        //如果左子树为null的话就
        if(node.left == null){
            //就是要删除掉node这个节点
            //先将right赋值给一个新的节点，这个新的节点就是下个根节点（替换当前被删除的节点）
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax(){
        E maxmum = this.maximum();
        root = this.removeMax(root);
        return maxmum;
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

    /**
     * 返回当前二分搜索树的最小值
     * @return
     */
    public E minimum(){
        if(size == 0){
            return null;
        }
        return (E) minimum(root).e;
    }

    private Node minimum(Node root) {
        if(root.left == null){
            return root;
        }
        return minimum(root.left);
    }
    /**
     * 返回当前二分搜索树的最大值
     * @return
     */
    public E maximum(){
        if(size == 0){
            return null;
        }
        return (E) maximum(root).e;
    }

    private Node maximum(Node root) {
        if(root.right == null){
            return root;
        }
        return maximum(root.right);
    }

    public void remove(E e){
        root = this.remove(root,e);
    }

    /**
     * 删除以node为根的二分搜索树中的值为e 的节点
     * 返回删除节点后的二分搜索树的根
     * @param node
     * @param e
     * @return
     */
    private Node remove(Node node, E e) {
        if(node == null){
            return null;
        }
        if(e.compareTo((E) node.e)<0){
            //删除的元素在左子树上
            node.left = this.remove(node.left,e);
            return node;
        }else if (e.compareTo((E) node.e)>0){
            //删除的元素在右子树上
            node.right = this.remove(node.right,e);
            return node;
        }else {
            //待删除的节点 左子树为null的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            //待删除的节点 右子树为null的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }
            //找到比待删除节点后继节点
            Node successor = minimum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.right = node.left = null;
            return successor;

//            //找到比待删除节点的前驱节点
//            Node successor = maximum(node.left);
//            successor.left = removeMax(node.left);
//            successor.right = node.right;
//            node.right = node.left = null;
//            return successor;
        }
    }
}
