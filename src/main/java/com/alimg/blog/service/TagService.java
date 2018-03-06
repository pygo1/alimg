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

    /**
     * 查询文章
     *
     * @param offset 查询开始位置
     * @param limit 查询多少条
     * @param tag 标签
     * @return 文章列表
     */
    List<Article> getArticle(Integer offset, int limit,String tag);

    /**
     * 查询文章总数
     *
     * @param tag 标签名
     * @return 符合条件标签的文章总数
     */
    int getCountbyTag(String tag);

    /**
     * 查询标签云
     *
     * @return 所有标签group
     */
    List<TagCloudExecution> getTagCloud();

}
