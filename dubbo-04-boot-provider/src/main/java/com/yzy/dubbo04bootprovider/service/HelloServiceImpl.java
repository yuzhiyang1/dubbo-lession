package com.yzy.dubbo04bootprovider.service;

import com.yzy.HelloRequest;
import com.yzy.HelloResponse;
import com.yzy.HelloService;
import org.apache.dubbo.config.annotation.DubboService;

import java.util.concurrent.CompletableFuture;

/**
 * hello服务impl
 * 测试使用protobuf协议服务的实现类
 *
 * @author yzy
 * @date 2023/09/10
 */
@DubboService
public class HelloServiceImpl implements HelloService {
    @Override
    public HelloResponse sayHello(HelloRequest request) {
        System.out.println("HelloServiceImpl.sayHello");
        System.out.println("request.name = " + request.getName());
        return HelloResponse.newBuilder().setResult("this is sayHello result").build();
    }

    @Override
    public CompletableFuture<HelloResponse> sayHelloAsync(HelloRequest request) {
        return CompletableFuture.completedFuture(sayHello(request));
    }
}
