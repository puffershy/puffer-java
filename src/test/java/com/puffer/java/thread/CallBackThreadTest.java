package com.puffer.java.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.testng.annotations.Test;
import org.testng.collections.Lists;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class CallBackThreadTest {

    @Test
    public void testCall() throws ExecutionException, InterruptedException {

        // 创建线程池
        int batchNum = 8;
        int DEFAULT_THREAD_NUM = 4;
        ThreadFactory nameThreadFactory = new ThreadFactoryBuilder().setNameFormat("job-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(DEFAULT_THREAD_NUM, DEFAULT_THREAD_NUM, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(), nameThreadFactory);

        final CountDownLatch countDownLatch = new CountDownLatch(batchNum);

        List<Future<Boolean>> resultList = Lists.newArrayList();

        // 多线程计算日切数据
        for (int batchNo = 0; batchNo < batchNum; batchNo++) {
            // executorService.execute(new CallBackThread(countDownLatch));
            Future<Boolean> submit = executorService.submit(new CallBackThread(countDownLatch, batchNo));
            resultList.add(submit);
            System.out.println("over" + batchNo);
            // System.out.println(resultList + " " + batchNo);
        }

        try {
            countDownLatch.await();
            resultList.forEach(booleanFuture -> {
                try {
                    System.out.println(booleanFuture.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
            System.out.println(resultList);
        } catch (Exception e) {
            System.out.println("异常");
        } finally {
            executorService.shutdown();// 关闭线程池
        }

    }
}