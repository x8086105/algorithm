package com.example.algorithm.Demo;

import com.example.algorithm.dataStructure.LinkedList;

public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0;i<10;i++){
            linkedList.addLast(i);
            System.out.println(linkedList);
        }
        linkedList.add(666,2);
        System.out.println(linkedList);
        for(int i = 0;i<10;i++){
            linkedList.removeFist();
            System.out.println(linkedList);
        }
    }
}
