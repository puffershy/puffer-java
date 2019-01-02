package com.puffer.java.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author buyi
 * @date 2019年01月02日 17:24:09
 * @since
 */
public class ThreadJob implements Runnable {
    private final CountDownLatch countDownLatch;

    public ThreadJob(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        countDownLatch.countDown();
    }
}
