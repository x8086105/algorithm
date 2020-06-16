package com.example.algorithm.dataStructure;

public class ArrayQueue<E> implements Queue<E> {
    private Array<E> array;

    public ArrayQueue(){
        this(10);
    }

    public ArrayQueue(int capacity){
        array = new Array<>(capacity);
    }
    @Override
    public void enqueue(E o) {
        array.addLast(o);
    }

    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue:");
        sb.append("front:[");
        for(int i = 0;i<array.getSize();i++){
            sb.append(array.get(i));
            if(i != array.getSize() - 1){
                sb.append(",");
            }
        }
        sb.append("]tail");
        return sb.toString();
    }
}
