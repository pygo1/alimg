package com.alimg.blog.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;
import java.util.List;


public class Article {

    private Integer id;

    private Integer authorId;

    private String title;

    private String content;
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date modifyTime;
    @JSONField (format="yyyy-MM-dd HH:mm:ss")
    private Date publishTime;

    private String level;

    private String click;

    private String sort;

    private List<Item> item;

    private List<Tag> tag;

    private User user;

    public Article() {

    }

    public Article(Integer id, Integer authorId, String title, String content, Date createTime, Date modifyTime, Date publishTime, String level, String click, String sort) {
        this.id = id;
        this.authorId = authorId;
        this.title = title;
        this.content = content;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
        this.publishTime = publishTime;
        this.level = level;
        this.click = click;
        this.sort = sort;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getPublishTime() {
        return publishTime;
    }
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getClick() {
        return click;
    }

    public void setClick(String click) {
        this.click = click;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public List<Tag> getTag() {
        return tag;
    }

    public void setTag(List<Tag> tag) {
        this.tag = tag;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", authorId='" + authorId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", modifyTime=" + modifyTime +
                ", publishTime=" + publishTime +
                ", level='" + level + '\'' +
                ", click='" + click + '\'' +
                ", sort='" + sort + '\'' +
                ", item=" + item +
                ", tag=" + tag +
                ", user=" + user +
                '}';
    }
}
