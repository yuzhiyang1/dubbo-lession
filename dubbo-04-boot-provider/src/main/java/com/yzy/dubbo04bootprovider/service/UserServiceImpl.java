package com.yzy.dubbo04bootprovider.service;

import com.yzy.service.UserService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * 用户服务impl
 *
 * @author yzy
 * @date 2023/09/08
 */
@DubboService
public class UserServiceImpl implements UserService {
    @Override
    public boolean login(String name, String password) {
        System.out.println("UserServiceImpl.login" + "第一次dubbo调用");
        return false;
    }
}
