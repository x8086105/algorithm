package com.example.mutileThread;

import org.apache.poi.ss.formula.functions.T;

public class TestValitor {

    private  static int i = 0;

    private  static Object object = null;

    private static volatile boolean stop = false;

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
               object = new Object();
                stop = true;
                System.out.println("执行完了:" + stop);
            }
        },"thread1");

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (object == null){

                }
                System.out.println("stop!");
                System.out.println(i);
            }
        },"t1");
        t.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.start();

        System.out.println("end");
    }

    private static void method(){

    }
}
