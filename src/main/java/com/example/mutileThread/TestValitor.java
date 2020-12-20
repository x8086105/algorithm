package com.example.mutileThread;

import org.apache.poi.ss.formula.functions.T;

public class TestValitor {

    private  volatile static int i = 0;
    private final static Object object = new Object();
    private static volatile boolean stop = false;
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    i = 1;
                    i = 2;
                    i = 4;
                    stop = true;
                }
                System.out.println("执行完了:" + stop);
            }
        },"thread1");

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!stop){

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
