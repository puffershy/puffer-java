package com.puffer.java.design.factory;

/**
 * 发送者工厂类
 *
 * @author buyi
 * @date 2018年12月26日 17:21:18
 * @since 1.0.0
 */
public class SenderFactory {

    public static Sender createMail() {
        return new MailSenderImpl();
    }

    public static Sender createSms() {
        return new SmsSenderImpl();
    }
}
