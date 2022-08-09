package com.heaven.springsecurity.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.heaven.springsecurity.domain.User;

public interface UserService extends IService<User> {

    // 根据用户名查询用户
    User findByUsername(String username);

}
