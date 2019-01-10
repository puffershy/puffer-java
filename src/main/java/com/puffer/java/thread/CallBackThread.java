package com.puffer.java.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;

/**
 * 返回参数线程
 *
 * @author buyi
 * @date 2019年01月02日 17:31:38
 * @since 1.0.0
 */
public class CallBackThread implements Callable<Boolean> {

    private final CountDownLatch countDownLatch;
    private final int batchNo;

    public CallBackThread(CountDownLatch countDownLatch, int batchNo) {
        this.countDownLatch = countDownLatch;
        this.batchNo = batchNo;
    }

    @Override
    public Boolean call() {
        System.out.println(Thread.currentThread() + "" + batchNo);
        try {
            Thread.sleep(1000);
            if (batchNo % 2 == 0) {
                throw new RuntimeException("模拟异常");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            countDownLatch.countDown();
        }

        return false;
    }
}
