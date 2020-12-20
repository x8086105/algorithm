package com.example.algorithm.sourceCode;

import java.util.HashMap;

public class HashMapSourceTest {

    private static final int MAXIMUM_CAPACITY = 1<<30;

    public static void main(String[] args) {
        test1();
//        int c = tableSizeFor(18);
//        System.out.println(c);
        System.out.println("ABCDEa123abc".hashCode());

        System.out.println("ABCDFB123abc".hashCode());
    }

    /**
     * 测试HashMap最大能放多少个元素
     */

    public static void test1(){
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            map.put(i + "", i);
        }


    }

    static int tableSizeFor(int cap) {
        int n = cap - 1;
        int n1 = n>>>1;
        System.out.println("n1:" + n1);
        int result1 = n | n1;
        System.out.println("result1:" + result1);
        n |= n >>> 1;
        int n2 = n>>>2;
        System.out.println("n2:" + n2);
        int result2 = n | n2;
        System.out.println("result2:" + result2);
        n |= n >>> 2;
        int n3 = n>>>4;
        System.out.println("n3:" + n3);
        int result3 = n | n3;
        System.out.println("result3:" + result3);
        n |= n >>> 4;
        int n4 = n>>>8;
        System.out.println("n4:" + n4);
        int result4 = n | n4;
        System.out.println("result4:" + result4);
        n |= n >>> 8;
        int n5 = n>>>16;
        System.out.println("n5:" + n5);
        int result5 = n | n5;
        System.out.println("result5:" + result5);
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;

    }
}
