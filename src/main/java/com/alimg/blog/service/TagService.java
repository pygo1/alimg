package com.alimg.blog.service;

import com.alimg.blog.dto.TagCloudExecution;
import com.alimg.blog.entity.Article;
import com.alimg.blog.entity.Tag;

import java.util.List;

public interface TagService {
    /**
     * 查询所有Tag
     *
     * @return
     */
    List<Tag> getList();

    List<Article> getArticle(Integer offset, int limit,String tag);

    int getCountbyTag(String tag);

    List<TagCloudExecution> getTagCloud();

}
