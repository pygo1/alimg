package com.alimg.blog.dao;

import org.apache.ibatis.annotations.Param;

public interface TagDao {

    void insertTag(@Param("article_id") Integer articleId, @Param("names") String[] tags);

    void modifyTag(@Param("article_id") Integer articleId, @Param("names") String[] tags);

    void deleteTag(@Param("article_id") Integer articleId);
}
