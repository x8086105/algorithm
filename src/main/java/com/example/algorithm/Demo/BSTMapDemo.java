package com.example.algorithm.Demo;

import com.example.algorithm.dataStructure.BSTMap;

import java.sql.SQLOutput;

/**
 * BSTMap 测试其中的方法
 */
public class BSTMapDemo {
    public static void main(String[] args) {
        BSTMap<Integer,Integer> bstMap = new BSTMap<>();
        for(int i = 0;i < 10; i++){
            bstMap.add(i,i);
        }
        boolean contains2 = bstMap.contains(2);
        System.out.println("contains 2 :" + contains2);
        boolean contains10 = bstMap.contains(10);
        System.out.println("contains 10 :" + contains10);
        Integer value3 = bstMap.get(3);
        System.out.println("value3:" + value3);
        bstMap.set(9,10);
        bstMap.removeMin();
        bstMap.preTraversal();
    }
}
