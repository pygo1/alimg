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
     * @param item  查询栏目
     * @param search  查询检索
     * @return 符合条件所有文章
     */
    List<Article> queryAll(@Param("offset") int offset, @Param("limit") int limit,@Param("item") int item,@Param("search") String search);

    /**
     * 查询所有置顶Article
     *
     * @param item  查询栏目
     * @return 符合条件所有文章
     */
    List<Article> queryTop(@Param("item") int item);

    /**
     * 查询Article
     *
     * @param id 查询文章id
     * @return 符和id文章
     */
    Article selectArticle(@Param("id") int id);

    /**
     * 查询Article数目
     *
     * @param item  查询栏目
     * @param search  查询检索
     * @return 符合条件所有文章数目
     */
    int selectArticleCount(@Param("item") int item,@Param("search") String search);

    /**
     * 插入Article
     *
     * @param article 文章
     * @return 插入文章id
     */
    int insertArticle(@Param("article") Article article);

    /**
     * 修改Article
     *
     * @param article 文章
     * @return 修改文章id
     */
    int modifyArticle(@Param("article") Article article);

    /**
     * 删除Article
     *
     * @param id 文章id
     * @return void
     */
    void deleteArticle(@Param("id") int id);

    /**
     * 更新Article点击数
     *
     * @param id 文章id
     * @return void
     */
    void updateArticleClick(@Param("id") int id);
}
