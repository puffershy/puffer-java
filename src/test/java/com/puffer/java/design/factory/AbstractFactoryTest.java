package com.puffer.java.design.factory;

import com.puffer.java.design.factory.abstractfactory.MailSenderFactory;
import com.puffer.java.design.factory.abstractfactory.Provider;
import org.testng.annotations.Test;

/**
 * 抽象工厂测试
 *
 * @author buyi
 * @date 2018年12月26日 17:28:16
 * @since
 */
public class AbstractFactoryTest {

    @Test
    public void test() {
        Provider provider = new MailSenderFactory();
        provider.produce().send();
    }
}
