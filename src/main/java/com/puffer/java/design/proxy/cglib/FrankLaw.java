package com.puffer.java.design.proxy.cglib;

/**
 * 诉讼类
 *
 * @author buyi
 * @date 2018年12月26日 16:51:18
 * @since 1.0.0
 */
public class FrankLaw {

    public void submit(String proof) {
        System.out.println(String.format("提交诉讼，证据：%s", proof));
    }
}
