package com.example.mutileThread;

import ch.qos.logback.core.util.TimeUtil;
import lombok.SneakyThrows;

import java.text.CharacterIterator;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new Runnable() {

            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(TimeUnit.MILLISECONDS.toMillis(1500));
                System.out.println("所有线程都完成了自己的工作，现在开始合并结果了.......");
            }
        });
        new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println("线程1执行了自己的一部分工作");
                Thread.sleep(TimeUnit.MILLISECONDS.toMillis(1000));
                cyclicBarrier.await();
                System.out.println("最终结果完成，线程1可以退出");
            }
        }.start();
        new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(TimeUnit.MILLISECONDS.toMillis(1000));

                System.out.println("线程2执行了自己的一部分工作");

                cyclicBarrier.await();                System.out.println("最终结果完成，线程2可以退出");

            }
        }.start();
        new Thread() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println("线程3执行了自己的一部分工作");
                Thread.sleep(TimeUnit.MILLISECONDS.toMillis(1000));

                cyclicBarrier.await();                System.out.println("最终结果完成，线程3可以退出");

            }
        }.start();
    }
}
