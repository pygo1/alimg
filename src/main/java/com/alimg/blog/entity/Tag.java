package com.alimg.blog.entity;

public class Tag {

    private Integer id;

    private String name;

    private  String info;

    private String mark;

    private Integer article_id;

    public Tag() {
    }

    public Tag(Integer id, String name, String info, String mark, Integer article_id) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.mark = mark;
        this.article_id = article_id;
    }

    public long getId() {
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

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public long getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", info='" + info + '\'' +
                ", mark='" + mark + '\'' +
                ", article_id=" + article_id +
                '}';
    }
}
