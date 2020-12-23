package com.example.mutileThread;

import lombok.SneakyThrows;

public class ThreadLocalTest {
    private static ThreadLocal<Integer> t = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {

        t.set(10);
        Thread.sleep(300);
        Thread t1 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                t.set(100000);
                Thread.sleep(100);
                System.out.println("t1 线程中的值是：" + t.get());
            }
        });
        t1.start();

        System.out.println("main 线程中的值是：" + t.get());
    }
}
