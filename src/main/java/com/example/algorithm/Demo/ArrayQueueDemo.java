package com.example.algorithm.Demo;

import com.example.algorithm.dataStructure.ArrayQueue;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>(10);
        for(int i = 1;i<=12;i++){
            arrayQueue.enqueue(i);
            System.out.println(arrayQueue);
            if(i%3 == 2){
                arrayQueue.dequeue();
                System.out.println(arrayQueue);
            }
        }

    }

}
