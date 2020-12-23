package com.example.mutileThread;

import java.util.concurrent.CountDownLatch;

public class SampleServiceB extends AbstractService{

    public SampleServiceB(CountDownLatch latch) {
        super(latch);
    }

    @Override
    protected void doStart() throws Exception {

    }
}
