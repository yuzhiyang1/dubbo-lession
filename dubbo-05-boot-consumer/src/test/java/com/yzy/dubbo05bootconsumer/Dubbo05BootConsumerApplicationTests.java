package com.yzy.dubbo05bootconsumer;

import com.yzy.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Dubbo05BootConsumerApplicationTests {

    @DubboReference(url = "dubbo://192.168.1.10:20880/com.yzy.service.UserService")
    private UserService userService;

    /**
     * dubbo 测试1
     * 测试通过注解的方式能不能获取到服务
     */
    @Test
    void dubboTest1() {
        boolean login = userService.login("小明", "123345");
        System.out.println("login = " + login);
    }

}
