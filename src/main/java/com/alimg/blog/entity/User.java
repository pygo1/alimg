package com.alimg.blog.entity;

import java.util.Date;

public class User {;

    private Integer id;

    private String name;

    private String info;

    private String img;

    private String pwd;

    private Date createTime;

    private Date updateTime;

    private String authorLevel;

    private String mark;

    public User() {
    }

    public User(Integer id, String name, String info, String img, String pwd, Date createTime, Date updateTime, String authorLevel, String mark) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.img = img;
        this.pwd = pwd;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.authorLevel = authorLevel;
        this.mark = mark;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAuthorLevel() {
        return authorLevel;
    }

    public void setAuthorLevel(String authorLevel) {
        this.authorLevel = authorLevel;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", img='" + img + '\'' +
                ", pwd='" + pwd + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", authorLevel='" + authorLevel + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}
