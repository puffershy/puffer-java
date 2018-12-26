package com.puffer.java.design.factory.abstractfactory;

import com.puffer.java.design.factory.MailSenderImpl;
import com.puffer.java.design.factory.Sender;

/**
 * 邮件工厂
 *
 * @author buyi
 * @date 2018年12月26日 17:26:14
 * @since 1.0.0
 */
public class MailSenderFactory implements Provider {
    @Override
    public Sender produce() {
        return new MailSenderImpl();
    }
}
