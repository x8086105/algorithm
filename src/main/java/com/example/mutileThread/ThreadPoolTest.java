package com.example.mutileThread;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    public static void main(String[] args) {
        System.out.println("RUNNING: " + RUNNING);
        System.out.println("SHUTDOWN: " + SHUTDOWN);
        System.out.println("STOP: " + STOP);
        System.out.println("TIDYING: " + TIDYING);
        System.out.println("TERMINATED: "+ TERMINATED);

        System.out.println("stop:"+ (int)Math.pow(2,29));

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,
                1000,TimeUnit.SECONDS, new LinkedBlockingQueue<>(100));
        executor.allowCoreThreadTimeOut(true);
    }
}
