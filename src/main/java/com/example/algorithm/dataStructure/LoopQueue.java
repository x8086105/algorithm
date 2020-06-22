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

    /**
     * 循环队列的入队
     * @param e
     */
    @Override
    public void enqueue(E e) {
        //判断是否能入队
        if((tail + 1) % data.length == front){
//            throw new IllegalArgumentException("enqueue failed not empty");
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity + 1];
        for(int i = 0;i<size;i++){
            newData[i] = data[(front + i)%data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    /**
     * 循环队列的出队
     * @return
     */
    @Override
    public E dequeue() {
        if(isEmpty()){
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }
        E req = data[front];
        front = (front + 1 )%data.length;
        size --;
        if(size == getCapacity() / 4){
            resize(getCapacity()/2);
        }
        return req;
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


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = front;i != tail;i = (i + 1) % data.length){
            sb.append(data[i]);
            if(i != tail - 1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
