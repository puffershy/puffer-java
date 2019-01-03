package com.puffer.java.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author buyi
 * @date 2019年01月02日 17:24:09
 * @since
 */
public class ThreadJob implements Runnable {
    private final CountDownLatch countDownLatch;
    private final int batchNo;

    public ThreadJob(CountDownLatch countDownLatch, int batchNo) {
        this.countDownLatch = countDownLatch;
        this.batchNo = batchNo;
    }

    @Override
    public void run() {
        System.out.println(batchNo);
        countDownLatch.countDown();
    }
}
