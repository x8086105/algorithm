package com.example.algorithm.Demo;

import com.example.algorithm.dataStructure.LoopQueue;

/**
 * 用来测试循环队列
 */
public class LoopQueueDemo {

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0;i<10;i++){
            queue.enqueue(i);
        }
        System.out.println(queue);
        for(int i = 0;i<3;i++){
            queue.dequeue();
        }
        System.out.println(queue);
    }

}
