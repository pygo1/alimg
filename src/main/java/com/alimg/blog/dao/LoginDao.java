package com.alimg.blog.dao;

import com.alimg.blog.entity.User;
import org.apache.ibatis.annotations.Param;

public interface LoginDao {
    /**
     * 获取用户
     *
     * @param email 用户名
     * @param password 密码
     * @return 用户
     */
    User getUser(@Param("email") String email, @Param("password") String password);
}
