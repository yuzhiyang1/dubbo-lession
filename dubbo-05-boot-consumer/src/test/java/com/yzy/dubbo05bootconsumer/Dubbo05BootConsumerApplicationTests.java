package com.yzy.dubbo05bootconsumer;

import com.yzy.HelloRequest;
import com.yzy.HelloResponse;
import com.yzy.HelloService;
import com.yzy.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Dubbo05BootConsumerApplicationTests {

    @DubboReference(url = "dubbo://192.168.1.10:20880/com.yzy.service.UserService")
    private UserService userService;

    @DubboReference(url = "dubbo://192.168.1.10:20880/com.yzy.HelloService?serialization=protobuf")
    private HelloService helloService;

    /**
     * dubbo 测试1
     * 测试通过注解的方式能不能获取到服务
     */
    @Test
    void dubboTest1() {
        boolean login = userService.login("小明", "123345");
        System.out.println("login = " + login);
    }

    /**
     * 测试使用 protobuf 序列化实现远端调用
     */
    @Test
    void dubboTest2() {
        HelloResponse helloResponse = helloService.sayHello(HelloRequest.newBuilder()
                .setName("使用Spring Boot测试")
                .build());
        System.out.println("helloResponse.getResult = " + helloResponse.getResult());

    }

}
