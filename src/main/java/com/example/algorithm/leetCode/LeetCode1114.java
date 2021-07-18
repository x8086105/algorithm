package com.example.algorithm.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LeetCode1114 {
    private static AtomicInteger jobDone = new AtomicInteger(0);

    public static void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        while(!jobDone.compareAndSet(0,1)){

        }

        printFirst.run();
    }

    public static void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        while(!jobDone.compareAndSet(1,2)){
        }
        List<Integer> s=new ArrayList<>();
        String ss = "";
        ss += ss.charAt(1);

    }

    public static void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        while(!jobDone.compareAndSet(2,3)){
        }
        printThird.run();
    }

    public static void main(String[] args) throws InterruptedException {
        first(new Runnable() {
            @Override
            public void run() {
                System.out.println("first");
            }
        });third(new Runnable() {
            @Override
            public void run() {
                System.out.println("third");
            }
        });
        second(new Runnable() {
            @Override
            public void run() {
                System.out.println("second");
            }
        });

    }
}
