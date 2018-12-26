package com.puffer.java.design.proxy;

/**
 * 静态，代理律师
 *
 * @author buyi
 * @date 2018年12月26日 17:06:05
 */
public class LawyerImpl implements LawSuit {
    private LawSuit lawSuit;

    public LawyerImpl(LawSuit lawSuit) {
        this.lawSuit = lawSuit;
    }

    @Override
    public void submit(String proof) {
        System.out.println("静态代理，前置业务处理");
        this.lawSuit.submit(proof);
    }
}
