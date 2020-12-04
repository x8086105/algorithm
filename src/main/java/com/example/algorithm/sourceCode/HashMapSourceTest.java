package com.example.algorithm.sourceCode;

import java.util.HashMap;

public class HashMapSourceTest {

    public static void main(String[] args) {
        test1();
    }

    /**
     * 测试HashMap最大能放多少个元素
     */

    public static void test1(){
        HashMap<Integer,Integer> map = new HashMap<>(16);
        Integer i = map.put(1,2);
        System.out.println(i);
    }
}
