package com.alimg.blog.dao;

import com.alimg.blog.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagDao {

    void insertTag(@Param("article_id") Integer articleId, @Param("names") String[] tags);

    void modifyTag(@Param("article_id") Integer articleId, @Param("names") String[] tags);

    void deleteTag(@Param("article_id") Integer articleId);

    List<Article> selectArticleInTag(@Param("offset") int offset, @Param("limit") int limit,@Param("tag") String tag);

    int selectArticleCountByTag(@Param("tag") String tag);
}
