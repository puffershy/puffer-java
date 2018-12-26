package com.puffer.java.design.proxy;

/**
 * 肥揪诉讼实现
 *
 * @author buyi
 * @date 2018年12月26日 16:20:37
 * @since 1.0.0
 */
public class FeiJiuLawImpl implements LawSuit {
    @Override
    public void submit(String proof) {
        System.out.println(String.format("提交诉讼，证据：%s", proof));
    }
}
