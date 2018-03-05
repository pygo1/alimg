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
    List<Article> queryAll(@Param("offset") int offset, @Param("limit") int limit,@Param("item") int item,@Param("search") String search);
    List<Article> queryTop(@Param("item") int item);

    Article selectArticle(@Param("id") int id);

    int selectArticleCount(@Param("item") int item,@Param("search") String search);

    int insertArticle(@Param("article") Article article);

    int modifyArticle(@Param("article") Article article);

    void deleteArticle(@Param("id") int id);

    void updateArticleClick(@Param("id") int id);
}
