package com.example.mutileThread;

import java.util.concurrent.CountDownLatch;

public class SampleServiceA extends AbstractService{

    public SampleServiceA(CountDownLatch latch) {
        super(latch);
    }

    @Override
    protected void doStart() throws Exception {

    }
}
