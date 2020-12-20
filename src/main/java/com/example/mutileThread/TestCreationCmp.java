package com.example.mutileThread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * java多线程编程实战指南
 * 清单 1-5线程的两种创建方式的区别
 */
public class TestCreationCmp {

    public static void main(String[] args) {
        Thread t;
        CountingTask task = new CountingTask();

        final int numberOfProcessors = Runtime.getRuntime().availableProcessors();
        System.out.println("numberOfProcessors:" + numberOfProcessors);
        for(int i = 0; i < 2*numberOfProcessors; i++){
            t = new Thread(task);
            t.start();
        }

        for(int i = 0; i < 2*numberOfProcessors; i++){
            t = new CountingThread();
            t.start();
        }

    }
    static class Counter{

        int count ;

        public void increment(){
            count++;
        }

        public int value(){
            return count;
        }

    }

    static class CountingTask implements Runnable{

        private Counter counter = new Counter();
        @Override
        public void run() {
            for(int i = 0; i < 100;i++){
                doSomething();
                counter.increment();
            }
            System.out.println("CountingTask:" + counter.value());
        }

        private void doSomething() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class CountingThread extends Thread{

        private Counter counter = new Counter();

        @Override
        public void run() {
            for(int i = 0; i < 100;i++){
                doSomething();
                counter.increment();

            }
            System.out.println("CountingThread:" + counter.value());
        }

        private void doSomething() {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
