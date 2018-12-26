package com.puffer.java.design.factory;

/**
 * 短信发送
 *
 * @author buyi
 * @date 2018年12月26日 17:19:57
 * @since 1.0.0
 */
public class SmsSenderImpl implements Sender {
    @Override
    public void send() {
        System.out.println("SMS SENDER");
    }
}
