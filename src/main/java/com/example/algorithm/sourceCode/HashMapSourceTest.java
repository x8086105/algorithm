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

        Integer i2 = map.put(1,222);
        System.out.println(i);
        int tableSizeFor = tableSizeFor(10);
        System.out.println(tableSizeFor);
    }

    static int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1 << 30) ? 1 << 30 : n + 1;
    }
}
