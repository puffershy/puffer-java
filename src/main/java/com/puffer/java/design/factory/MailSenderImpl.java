package com.puffer.java.design.factory;

/**
 * 邮件发送
 *
 * @author buyi
 * @date 2018年12月26日 17:19:33
 * @since 1.0.0
 */
public class MailSenderImpl implements Sender {
    @Override
    public void send() {
        System.out.println("MAIL SENDER");
    }
}
