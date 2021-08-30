package com.example.mutileThread;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;

@Slf4j
public abstract class AbstractService implements Service {

    protected boolean started = false;

    protected final CountDownLatch latch;

    public AbstractService(CountDownLatch latch) {

        this.latch = latch;
    }

    protected abstract void doStart() throws Exception;

    @Override
    public boolean isStarted() {
        return started;
    }

    @Override
    public void start() {
        new ServiceStart().start();
    }

    @Override
    public void stop() {

    }

    class ServiceStart extends Thread{
        @Override
        public void run() {

            final String serviceName = AbstractService.this.getClass().getSimpleName();
            log.info("Starting {}",serviceName);
            try {
                doStart();
                started = true;
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                latch.countDown();
                log.info("done Starting {}",serviceName);
            }
        }
    }
}
