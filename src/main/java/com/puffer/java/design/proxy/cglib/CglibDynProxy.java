package com.puffer.java.design.proxy.cglib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Cglib代理类
 *
 * @author buyi
 * @date 2018年12月26日 16:52:58
 * @since
 */
public class CglibDynProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("代理前置业务处理");
        return methodProxy.invokeSuper(o, objects);
    }
}
