package com.alimg.blog.dto;

import com.alimg.blog.entity.User;
import com.alimg.blog.enums.LoginStateEnum;

public class LoginExecution {

    private String email;

    private int state;

    private String stateInfo;

    private User user;

    public LoginExecution() {
    }

    public LoginExecution(String email, LoginStateEnum stateEnum){
        this.email = email;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public LoginExecution(String email, LoginStateEnum stateEnum, User user){
        this.email = email;
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "LoginExecution{" +
                "email='" + email + '\'' +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", user=" + user +
                '}';
    }
}
