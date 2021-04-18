package com.example.mutileThread;

import java.util.concurrent.atomic.LongAdder;

public class DeamThreadTest  {

    public static void main(String[] args) {
//        Thread thread = new Thread(new ThreadTest());
//        thread.start();
        Thread tt = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){

                }
            }
        });
        tt.setDaemon(true);
        tt.start();
        System.out.println("main运行结束");
    }

    private static class ThreadTest implements Runnable{

        @Override
        public void run() {
            System.out.println("开启子线程");
            try {
                LongAdder longAdder = new LongAdder();
                longAdder.increment();
                Thread.sleep(2000);
                while(true){

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程运行结束");
        }
    }
}
