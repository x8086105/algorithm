package com.example.jvm;


import java.util.List;

/**
 * 测试新生代垃圾回收
 *
 */
public class GCDetails {

    public static void main(String[] args) {
        byte[] arr1 = new byte[1024 * 1024];
        arr1 = new byte[1024*1024];
        arr1 = new byte[1024*1024];
        arr1 = null;

        byte[] arr2 = new byte[1024 * 1024 * 2];

    }
}
