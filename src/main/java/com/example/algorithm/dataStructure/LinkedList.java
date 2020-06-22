package com.example.algorithm.dataStructure;


/**
 * 链表
 * 2020-06-20 改
 * 添加虚拟头结点
 */
public class LinkedList<E> {
    private class Node<E>{
        private E e;
        private Node next;

        public Node(){
            this(null,null);
        }
        public Node(E e){
            this.e = e;
            this.next = null;
        }
        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedList(){
        dummyHead = new Node<E>(null,null);
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }


    public void add(E e,int index){
        if(index < 0 || index > size){
            throw new IllegalArgumentException("Add failed,Illegal index.");
        }

        Node prev = dummyHead;
        for( int i = 0;i<index;i++){
            prev = prev.next;
        }
//            Node<E> newNode = new Node<>(e);
//            newNode.next = prev.next;
//            prev.next = newNode;
        prev.next  = new Node<E>(e,prev.next);
        size ++;

    }

    public void addFirst(E e){
//        Node<E> newNode = new Node<>(e);
//        newNode.next = head;
//        head = newNode;
//        head = new Node<E>(e,head.next);
//        size ++;

        add(e,0);
    }

    public void addLast(E e){
        add(e,size);
    }
    public E get(int index){
        if(index < 0 || index >= size){
            throw  new IllegalArgumentException("Get failed.Illegal index.");
        }
        Node<E> cur = dummyHead.next;
        for(int i = 0;i<index;i++){
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFist(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }

    public void set(int index,E e){
        if(index < 0 || index >= size){
            throw  new IllegalArgumentException("Get failed.Illegal index.");
        }
        Node<E> cur = dummyHead.next;
        for(int i = 0;i<index;i++){
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e){
        Node<E> cur = dummyHead.next;
        while (cur.next != null){
            if(cur.e.equals(e)){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public E remove(int index){
        if(index < 0 || index >= size){
            throw  new IllegalArgumentException("Get failed.Illegal index.");
        }
        Node pre = dummyHead;
        for(int i = 0;i< index;i++){
            pre = pre.next;
        }
        Node<E> delNode = pre.next;
        pre.next = delNode.next;
        delNode.next = null;
        size --;
        return delNode.e;
    }

    public E removeFist(){
        return remove(0);
    }

    public E removeLast(){
        return remove(size -1);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for( Node<E> node = dummyHead.next; node != null;node = node.next){
            sb.append(node);
            sb.append("->");
            if(node.next == null){
                sb.append("NULL");
            }
        }
        return sb.toString();
    }
}
