package com.example.mutileThread;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;

import java.util.concurrent.CountDownLatch;

@Slf4j
public class CountDownLatchExample {

    private static  final CountDownLatch latch = new CountDownLatch(4);
    private static int data;

    /**
     * 这里程序输出的 data 4不是 10 是由于：首先， latch.countDown（）被 workerThread
     * 执行了4次之后， main 线程对 latch.await（）的调用就返回了，从而使该线程被唤醒 其次，
     * worker Thread 在执行 latch.countDown（） 前所执行的操作（更新共享变量 data ）的结果对等
     * 待线程（ main 线程）从 latch.await （）返回之后的代码可见，因 main 线程被唤醒时能够读
     * 取到 workerThread latch countDown（）调用返回前的操作结果一－data 被更新为4
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        Thread workerThread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                for(int i = 1; i < 10;i++){
                    Thread.sleep(100);
                    data = i;
                    latch.countDown();
                    System.out.println("xx");
                }
            }
        });
        Thread workerThread2 = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
               latch.await();
               System.out.println("workerThread2 操作......");
            }
        });
        workerThread.start();
        workerThread2.start();

        latch.await();
        log.info("It's done, data={}",data);
    }

}
