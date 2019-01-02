package com.puffer.java.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 简单线程
 *
 * @author buyi
 * @date 2019年01月02日 17:21:17
 * @since 1.0.0
 */
public class SimpleThread {
    public static void main(String[] args) {
        // 创建线程池
        int batchNum = 8;
        int DEFAULT_THREAD_NUM = 4;
        ThreadFactory nameThreadFactory = new ThreadFactoryBuilder().setNameFormat("job-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(DEFAULT_THREAD_NUM, DEFAULT_THREAD_NUM, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(), nameThreadFactory);

        final CountDownLatch countDownLatch = new CountDownLatch(batchNum);

        // 多线程计算日切数据
        for (int batchNo = 0; batchNo < batchNum; batchNo++) {
            executorService.execute(new ThreadJob(countDownLatch));
        }

        try {
            countDownLatch.await();
        } catch (Exception e) {
            System.out.println("异常");
        } finally {
            executorService.shutdown();// 关闭线程池
        }
    }
}
