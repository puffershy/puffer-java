package com.puffer.java.design.proxy;

import com.puffer.java.design.proxy.cglib.FrankLaw;
import org.testng.annotations.Test;

public class ProxyFactoryTest {

    @Test
    public void testGetDynProxy() {
        LawSuit lawSuit = (LawSuit) ProxyFactory.getDynProxy(new FeiJiuLawImpl());
        lawSuit.submit("工资明细");
    }

    @Test
    public void testGetCglibDynProxy() {
        FrankLaw frankLaw = (FrankLaw) ProxyFactory.getCglibDynProxy(new FrankLaw());
        frankLaw.submit("frank工资明细");

        FrankLaw cglibDynProxy = ProxyFactory.createCglibDynProxy(new FrankLaw());
        cglibDynProxy.submit("泛型测试");
    }

    @Test
    public void testGetStaticProxy() {
        LawSuit proxy = ProxyFactory.getStaticProxy(new FeiJiuLawImpl());
        proxy.submit("静态工资");
    }
}