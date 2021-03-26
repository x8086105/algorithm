package com.example.jvm;

/**
 * 测试对象进入老年代
 */
public class GCDetailBigObject {

    public static void main(String[] args) {
//        byte[] a1 = new byte[2 * 1024 * 1024];
//        a1 = new byte[2 * 1024 * 1024];
//        a1 = new byte[2 * 1024 * 1024];
//        a1 = null;
//
//        byte[] a2 = new byte[128 * 1024];
//
//
//        byte[] a3 = new byte[2 * 1024 * 1024];
//        a3 = new byte[2 * 1024 * 1024];
//        a3 = new byte[128 * 1024];
//        a3 = null;
//        byte[] a4 = new byte[2 * 1024 * 1024];



        byte[] a1 = new byte[4 * 1024 * 1024];
        a1 = null;

        byte[] a2 = new byte[2 * 1024 * 1024];
        byte[] a3 = new byte[2 * 1024 * 1024];
        byte[] a4 = new byte[2 * 1024 * 1024];
        byte[] a5 = new byte[800 * 1024];
        byte[] a6 = new byte[2 * 1024 * 1024];


    }
}
