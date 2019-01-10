package com.puffer.java.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SegmentUtilTest {

    @Test
    public void testCalculationSegment() {

        List<Long> productIds = buildIdList(100000);
        Map<Long, Integer> productMap = Maps.newHashMap();

        productIds.forEach(productId -> {
            Integer integer = SegmentUtil.calculationSegment(String.valueOf(productId));
            productMap.put(productId, integer);
        });

        //创建线程
        int DEFAULT_THREAD_NUM = 5;
        ThreadFactory nameThreadFactory = new ThreadFactoryBuilder().setNameFormat("job-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(DEFAULT_THREAD_NUM, DEFAULT_THREAD_NUM, 0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(), nameThreadFactory);

        final CountDownLatch countDownLatch = new CountDownLatch(productIds.size());

        List<Future<Pair<Long, Integer>>> resultList = Lists.newArrayList();
        for (int i = 0; i < productIds.size(); i++) {
            Long productId = productIds.get(i);
            Future<Pair<Long, Integer>> submit = executorService.submit(new MultiSegment(countDownLatch, productId));
            resultList.add(submit);
        }

        try {
            countDownLatch.await();
            resultList.forEach(future -> {
                try {
                    Pair<Long, Integer> pair = future.get();
                    Assert.assertEquals(pair.second(), productMap.get(pair.first()));
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

    public class MultiSegment implements Callable<Pair<Long, Integer>> {

        private final CountDownLatch countDownLatch;
        private final Long productId;

        public MultiSegment(CountDownLatch countDownLatch, Long productId) {
            this.countDownLatch = countDownLatch;
            this.productId = productId;
        }

        @Override
        public Pair<Long, Integer> call() throws Exception {

            Integer integer = SegmentUtil.calculationSegment(String.valueOf(productId));
            countDownLatch.countDown();

            return Pair.of(productId, integer);
        }
    }

    public List<Long> buildIdList(int size) {
        List<Long> list = Lists.newArrayList();
        for (int i = 0; i < size; i++) {

            list.add(Long.valueOf(System.currentTimeMillis() + "" + i));
        }

        return list;
    }
}