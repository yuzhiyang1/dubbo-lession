package com.yzy;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;


public class ProviderMain {
    public static void main(String[] args) throws InterruptedException {
        // 加载配置文件
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext-provider.xml");
        // 启动容器，扫描配置文件
        applicationContext.start();

        // 等待其他线程完成后再继续执行
        new CountDownLatch(1).await();
    }
}