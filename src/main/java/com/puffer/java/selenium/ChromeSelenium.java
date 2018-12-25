package com.puffer.java.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ChromeSelenium {

    public static void main(String[] args) {
        String chromeDriverPath = System.getProperty("user.dir").concat("/src/main/java/com/buyi/java/selenium/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);

        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://baidu.com");
    }

    @Test
    public void testChrome(){
        String chromeDriverPath = System.getProperty("user.dir").concat("/src/main/java/com/buyi/java/selenium/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);

        ChromeDriver chromeDriver = new ChromeDriver();
        chromeDriver.get("http://baidu.com");

    }
}
