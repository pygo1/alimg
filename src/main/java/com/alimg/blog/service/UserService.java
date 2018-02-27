package com.alimg.blog.service;

import com.alimg.blog.dto.LoginExecution;

public interface UserService {
    LoginExecution checkUser(String email, String password);
}
