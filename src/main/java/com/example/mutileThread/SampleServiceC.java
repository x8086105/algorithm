package com.example.mutileThread;

import java.util.concurrent.CountDownLatch;

public class SampleServiceC extends AbstractService{

    public SampleServiceC(CountDownLatch latch) {
        super(latch);
    }

    @Override
    protected void doStart() throws Exception {

    }
}
