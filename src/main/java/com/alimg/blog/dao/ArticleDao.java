package com.alimg.blog.dao;

import com.alimg.blog.entity.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleDao {
    /**
     * 查询所有Article
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return
     */
    List<Article> queryAll(@Param("offset") int offset, @Param("limit") int limit);

    int insertArticle(@Param("article") Article article);
}
