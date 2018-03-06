package com.alimg.blog.service;

import com.alimg.blog.dto.LoginExecution;

public interface UserService {
    /**
     * 查询用户
     *
     * @return 登录状态
     */
    LoginExecution checkUser(String email, String password);
}
