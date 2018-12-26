package com.puffer.java.design.factory;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SenderFactoryTest {

    @Test
    public void testCreateMail() {
        SenderFactory.createMail().send();
    }

    @Test
    public void testCreateSms() {
        SenderFactory.createSms().send();
    }
}