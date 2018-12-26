package com.puffer.java.design.factory.abstractfactory;

import com.puffer.java.design.factory.Sender;
import com.puffer.java.design.factory.SmsSenderImpl;

/**
 * 短信工厂
 *
 * @author buyi
 * @date 2018年12月26日 17:27:07
 * @since 1.0.0
 */
public class SmsSenderFactory implements  Provider {
    @Override
    public Sender produce() {
        return new SmsSenderImpl();
    }
}
