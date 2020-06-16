package com.example.algorithm.dataStructure;

public class LoopQueue<E> implements Queue<E> {
    private E []data;
    private int front,tail;
    private int size;

    public LoopQueue(){
        this(10);
    }
    public LoopQueue(int capacity){
        this.data = (E[]) new Object[capacity + 1];
        this.front = 0;
        this.tail = 0;
        this.size = 0;
    }
    @Override
    public void enqueue(E e) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E getFront() {
        return null;
    }
    public int getCapacity(){
        return data.length - 1;
    }
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }
}
