package com.example.mutileThread;

public class TestSync {
    private  static int i = 0;
    private static  int j  = 0;
    private static  Object lock = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock){
                    i = 1;
                    j = 2;
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(i + "；；" + j);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
