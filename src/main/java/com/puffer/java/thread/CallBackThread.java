package com.puffer.java.thread;

import java.util.concurrent.Callable;

/**
 * 返回参数线程
 *
 * @author buyi
 * @date 2019年01月02日 17:31:38
 * @since 1.0.0
 */
public class CallBackThread implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        return false;
    }
}
