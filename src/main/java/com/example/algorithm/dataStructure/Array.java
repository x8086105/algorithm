package com.example.algorithm.dataStructure;

import java.util.Arrays;
import java.util.Objects;

/**
 * 自定义动态数组。
 * 实现数组的增删查改等操作
 * 动态数组，实现了自动扩容/缩容的操作
 */
public class Array<E> {
    /**
     * 数组元素的数量
     */
    private int size;
    /**
     * 数组的大小
     */
    private int capacity;

    private E[] data;

    public Array(){
        this(10);
    }

    public Array(int capacity){
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    /**
     * 获取该数组中有多少个元素
     * @return 元素的个数
     */
    public int getSize(){
        return size;
    }

    /**
     * 获取该元素容器的大小
     * @return 容器的大小
     */
    public int getCapacity(){
        return data.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void addLast(E e){
        add(size,e);
    }

    public void addFirst(E e){
        add(0,e);
    }
    /**
     * 添加一个元素到指定的位置
     * @param position 指定的位置(需要插入的下标记)
     * @param e 添加的元素
     */
    public void add(int position,E e){

        if(position < 0 || position > size){
            throw new IllegalArgumentException("AddLast failed.Require index >=0 and index<=size");
        }
        if(size == data.length){
            resize(2 * data.length);
        }
        for(int i = size - 1;i >= position ; i--){
            data[i + 1] = data[i];
        }
        data[position] = e;
        size ++;
    }
    public boolean contains(E e){
        for(int i = 0; i < size; i++){
            if(data[i] == e){
                return true;
            }
        }
        return false;
    }

    /**
     * 查询e是否在这个数组中，如果有返回下标
     * @param e
     * @return
     */
    public int find(E e){
        for(int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }
    public E removeLast(){
        return removeAt(size - 1);
    }
    public E removeFirst(){
        return removeAt(0);
    }
    /**
     * 移除某个下标的元素
     * @param position 下标
     */
    public E removeAt(int position){
        if(position < 0 || position >= size){
            throw new IllegalArgumentException("removeAt failed.Require index >=0 and index<size");
        }
        E res = data[position];
        for(int i = position;i < size -1 ; i++){
            data[i] = data[i + 1];
        }
        size --;
        //进行缩容
        if(size == data.length / 4 && data.length / 2 >0){
            resize(data.length/2);
        }
        return res;
    }

    /**
     * 通过索引获取值
     * @param position
     * @return
     */
    public E get(int position){
        if(position <0 || position>=size){
            throw new IllegalArgumentException("get failed.Require index >=0 and index<size");
        }
        return data[position];
    }
    public E getLast(){
        return get(size-1);
    }
    public E getFirst(){
        return get(0);
    }
    /**
     * 通过下标以及元素重置某个下表的元素
     * @param position
     * @param e
     */
    public void set(int position,E e){
        if(position <0||position>=size){
            throw new IllegalArgumentException("get failed.Require index >=0 and index<size");
        }
        data[position] = e;
    }

    public void removeElement(E e){
        int index = this.find(e);
        if(index != -1){
            this.removeAt(index);
        }
    }
    /**
     * 重置数组大小，进行扩容或者缩容
     * @param newCapacity 新的数组的大小
     */
    private void resize(int newCapacity) {
        E []newData = (E[]) new Object[newCapacity];
        for(int i = 0; i < size;i++){
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder  dataStr = new StringBuilder("[");
        for(int i = 0;i<size;i++){
            dataStr.append(data[i]);
            dataStr.append(i == size - 1 ? "" : ",");
        }
        dataStr.append("]");

        return "Array{" +
                "size=" + getSize() +
                ", capacity=" + getCapacity() +
                ", data=" + dataStr.toString() +
                '}';
    }
}

