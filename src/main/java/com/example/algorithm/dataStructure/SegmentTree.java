package com.example.algorithm.dataStructure;

import com.sun.scenario.effect.Merge;

import java.util.Arrays;

/**
 * 线段树的底层实现
 * @param <E>
 */
public class SegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;
    public SegmentTree(E[] arr,Merger<E> merger){

        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for(int i = 0; i<arr.length; i++){
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0,0,data.length - 1);
    }

    /**
     * 在treeIndex的位置创建表示区间[l.....r]的线段树
     * @param treeIndex
     * @param l
     * @param r
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        //终止条件
        if(l == r){
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = l + (r - l)/2;
        //l,mid   和  mid +1,r
        buildSegmentTree(leftTreeIndex,l,mid);
        buildSegmentTree(rightTreeIndex,mid+1,r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex] , tree[rightTreeIndex]);
    }

    /**
     * 返回区间[queryL,queryR]的值
     * @param queryL
     * @param queryR
     * @return
     */
    public E query(int queryL,int queryR){
        if(queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length){
            throw new IllegalArgumentException("Index is illegal.");
        }
        return query(0,0,data.length - 1,queryL,queryR);
    }

    /**
     * 以treeIndex 为根节点的线段树中[l.....R]的返回里，
     * 搜索区间[queryL,queryR]的值
     * @return
     */
    private E query(int treeIndex,int l,int r,int queryL,int queryR){
        if(l == queryL && r == queryR){
            return tree[treeIndex];
        }
        int mid = l+(r-l)/2;
        int leftChildIndex = leftChild(treeIndex);
        int rightChildIndex = rightChild(treeIndex);
        if(queryL > mid + 1){
            return query(rightChildIndex,mid + 1,r,queryL,queryR);
        }else if (queryR <= mid){
            return query(leftChildIndex,l,mid,queryL,queryR);
        }
        //分跨左右孩子节点的
        E leftResult = query(leftChildIndex,l,mid,queryL,mid);
        E rightRequest = query(rightChildIndex,mid + 1,r,mid+1 ,queryR);
        return merger.merge(leftResult,rightRequest);
    }

    /**
     * 返回数组的长度
     * @return
     */
    public int getSize(){
        return data.length;
    }

    public E get(int index){
        if(index < 0 || index > data.length){
            throw  new IllegalArgumentException("Index is illegal.");
        }
        return data[index];
    }

    public int leftChild(int index){
        return index * 2 + 1;
    }

    public int rightChild(int index){
        return  index * 2 + 2;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for(int i = 0;i<tree.length;i++){
            if(tree[i]!=null){
                res.append(tree[i]);
            }else{
                res.append("null");
            }
            if(i!=tree.length - 1){
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }
}
