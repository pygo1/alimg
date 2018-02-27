package com.alimg.blog.dao;

import com.alimg.blog.entity.User;
import org.apache.ibatis.annotations.Param;

public interface LoginDao {

    User getUser(@Param("email") String email, @Param("password") String password);
}
