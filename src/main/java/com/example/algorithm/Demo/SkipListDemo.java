package com.example.algorithm.Demo;

import com.example.algorithm.dataStructure.SkipList;

public class SkipListDemo {
    public static void main(String[] args) {
        SkipList<Integer> skipList = new SkipList<>();
        skipList.init();
        skipList.put(1,1);
        System.out.println(skipList);
    }
}
