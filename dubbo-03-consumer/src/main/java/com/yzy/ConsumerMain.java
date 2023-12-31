package com.yzy;

import com.yzy.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

public class ConsumerMain {
    public static void main(String[] args) throws IOException {
        // 加载配置文件
        ClassPathXmlApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("applicationContext-consumer.xml");

        // 测试调用
        //UserService userService = (UserService) applicationContext.getBean("userService");

        //boolean login = userService.login("小明", "123456");
        //System.out.println("登录结果" + login);

        // 测试使用protobuf序列化方式调用的service
        HelloService helloService = applicationContext.getBean(HelloService.class);
        HelloRequest helloRequest = HelloRequest.newBuilder().setName("测试").build();
        HelloResponse helloResponse = helloService.sayHello(helloRequest);
        System.out.println("helloResponse.getResult = " + helloResponse.getResult());
        System.in.read();
    }
}