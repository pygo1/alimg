package com.alimg.blog.dto;

public class TagCloudExecution {

    private Integer count;

    private String name;

    public TagCloudExecution() {
    }

    public TagCloudExecution(Integer count, String name) {
        this.count = count;
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TagCloudExecution{" +
                "count=" + count +
                ", name='" + name + '\'' +
                '}';
    }
}
