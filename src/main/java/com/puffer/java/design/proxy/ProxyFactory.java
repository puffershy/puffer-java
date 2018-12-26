package com.puffer.java.design.proxy;

import com.puffer.java.design.proxy.cglib.CglibDynProxy;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

/**
 * 代理类工厂
 *
 * @author buyi
 * @date 2018年12月26日 16:24:19
 * @since
 */
public class ProxyFactory {

    /**
     * 创建静态代理类
     *
     * @param lawSuit
     * @return
     */
    public static LawSuit getStaticProxy(LawSuit lawSuit) {
        return new LawyerImpl(lawSuit);
    }

    /**
     * 创建java原生代理类
     *
     * @param target
     * @return
     */
    public static Object getDynProxy(Object target) {
        DynProxyLawyer dynProxyLawyer = new DynProxyLawyer(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), dynProxyLawyer);
    }

    /**
     * 创建cglib 代理类
     *
     * @param target
     * @return
     */
    public static Object getCglibDynProxy(Object target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new CglibDynProxy());
        return enhancer.create();
    }

    public static <T> T createCglibDynProxy(T t){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(t.getClass());
        enhancer.setCallback(new CglibDynProxy());
        return (T) enhancer.create();
    }
}
