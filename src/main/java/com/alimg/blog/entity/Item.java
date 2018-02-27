package com.alimg.blog.entity;

import java.util.Date;
import java.util.List;

public class Item {

    private long  id;

    private String name;

    private Date createTime;

    private String mark;

    private List<Item> children;

    private List<Article> articles;

    public Item() {
    }

    public Item(long id, String name, Date createTime, String mark) {
        this.id = id;
        this.name = name;
        this.createTime = createTime;
        this.mark = mark;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public List<Item> getChildren() {
        return children;
    }

    public void setChildren(List<Item> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createTime=" + createTime +
                ", mark='" + mark + '\'' +
                ", children=" + children +
                ", articles=" + articles +
                '}';
    }
}
