package com.alimg.blog.service.impl;

import com.alimg.blog.dao.LoginDao;
import com.alimg.blog.dto.LoginExecution;
import com.alimg.blog.entity.User;
import com.alimg.blog.enums.LoginStateEnum;
import com.alimg.blog.exception.LoginException;
import com.alimg.blog.exception.NoUserException;
import com.alimg.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private LoginDao LoginDao;

    public LoginExecution checkUser(String email, String password) {
        try {
            User user = LoginDao.getUser(email, password);
            if (user == null){
                throw new NoUserException("no user");
            }

            return new LoginExecution(email, LoginStateEnum.SUCCESS,user);
        }catch (NoUserException e1){
            throw e1;
        }catch (Exception e){
            //
            throw new LoginException(e.getMessage());
        }
    }
}
