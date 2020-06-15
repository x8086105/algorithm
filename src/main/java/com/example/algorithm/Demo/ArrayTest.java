package com.example.algorithm.Demo;

import com.example.algorithm.dataStructure.Array;

/**
 * 专门用来测试Array
 */
public class ArrayTest {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>(10);
        for(int i = 0;i<=20 ;i++){
            array.addLast(i);
        }
        System.out.println(array);
        for(int i = 0;i<=20 ;i++){
            array.removeAt(0);
        }
        System.out.println(array);

    }
}
