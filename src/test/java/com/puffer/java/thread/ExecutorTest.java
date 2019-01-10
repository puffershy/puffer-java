package com.puffer.java.thread;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.RandomUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author buyi
 * @date 2019年01月10日 16:10:56
 * @since
 */
public class ExecutorTest {

    // @Test
    // public void test() throws InterruptedException {
    //     int size = 7;
    //     final CountDownLatch countDownLatch = new CountDownLatch(size);
    //     ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(6);
    //     for (int i = 0; i < size; i++) {
    //         scheduledExecutorService.execute(new ThreadTest(countDownLatch));
    //     }
    //
    //     countDownLatch.await();
    //
    //     // scheduledExecutorService.shutdown();
    //
    //     System.out.println(scheduledExecutorService.isShutdown());
    //
    //     for (int i = 0; i < size; i++) {
    //         scheduledExecutorService.execute(new ThreadTest2());
    //     }
    //
    //     scheduledExecutorService.shutdown();
    //
    // }

    public static void main(String[] args) throws InterruptedException {
        int testSize = 10000;

        for (int i = 0; i < testSize; i++) {

            ConcurrentHashMap<Integer, List<Integer>> map = new ConcurrentHashMap<>();
            int size = 100000;
            List<Integer> list = buildList(size);

            Map<Integer, Integer> listMap = buildMap(list);

            int batchSize = 5;
            int batchNo = (list.size() - 1) / batchSize + 1;

            final CountDownLatch countDownLatch = new CountDownLatch(batchNo);
            ExecutorService executorService = Executors.newScheduledThreadPool(6);

            List<List<Integer>> partition = Lists.partition(list, batchSize);
            partition.forEach(subList -> {
                executorService.execute(new ThreadTest(countDownLatch, subList, map));
            });

            countDownLatch.await();

            map.forEach((key, value) -> {
                // System.out.println(key + "["+value.size()+"]=" + value);
                //     Assert.assertEquals(value.size(), listMap.get(key).intValue());

                if (value.size() != listMap.get(key).intValue()) {
                    System.out.println(key + "不相等" + value.size() + "-" + listMap.get(key).intValue());
                }

            });

            System.out.println("end。。。。。。。。。。。。。。。。。" + i);
        }

    }

    private static Map<Integer, Integer> buildMap(List<Integer> list) {
        Map<Integer, Integer> map = Maps.newHashMap();
        list.forEach(key -> {
            if (map.containsKey(key)) {
                Integer newValue = map.get(key) + 1;
                map.put(key, newValue);
                return;
            }

            map.put(key, 1);
        });

        return map;
    }

    private static List<Integer> buildList(int size) {
        List<Integer> list = Lists.newArrayList();
        for (int i = 0; i < size; i++) {
            list.add(RandomUtils.nextInt(10, 99));

        }
        return list;
    }

    public static class ThreadTest implements Runnable {

        private final CountDownLatch countDownLatch;
        private final List<Integer> subList;
        private final ConcurrentHashMap<Integer, List<Integer>> map;

        public ThreadTest(CountDownLatch countDownLatch, List<Integer> subList, ConcurrentHashMap<Integer, List<Integer>> map) {
            this.countDownLatch = countDownLatch;
            this.subList = subList;
            this.map = map;
        }

        @Override
        public void run() {
            subList.forEach(key -> {
                if (map.containsKey(key)) {
                    map.get(key).add(key);
                    return;
                }

                // map.put(key, Lists.newArrayList(key));
                List<Integer> integers = map.putIfAbsent(key, Lists.newArrayList(key));
                if (integers != null) {
                    System.out.println("error: " + key);
                    map.get(key).add(key);
                }

            });
            countDownLatch.countDown();
        }
    }

}
