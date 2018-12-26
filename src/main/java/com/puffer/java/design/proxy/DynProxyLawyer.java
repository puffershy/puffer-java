package com.puffer.java.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 诉讼代理类
 *
 * @author buyi
 * @date 2018年12月26日 16:22:02
 * @since 1.0.0
 */
public class DynProxyLawyer implements InvocationHandler {
    private Object target;

    public DynProxyLawyer(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理前置业务处理");
        return method.invoke(target,args);
    }
}
