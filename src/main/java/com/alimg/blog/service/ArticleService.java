package com.alimg.blog.service;

import com.alimg.blog.entity.Article;

import java.util.List;

public interface ArticleService {
    /**
     * 查询所有Article
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @param item  查询栏目
     * @param search  查询检索
     * @return 符合条件所有文章
     */
    List<Article> getList(Integer offset, int limit,int item ,String search);

    /**
     * 查询所有置顶Article
     *
     * @param item  查询栏目
     * @return 符合条件所有文章
     */
    List<Article> getTopList(int item);

    /**
     * 查询Article
     *
     * @param id 查询文章id
     * @return 符和id文章
     */
    Article getArticle(Integer id);

    /**
     * 查询Article数目
     *
     * @param item  查询栏目
     * @param search  查询检索
     * @return 符合条件所有文章数目
     */
    int getArticleCount(int item,String search);

    /**
     * 插入Article
     *
     * @param article 文章
     * @param item 文章栏目
     * @param tags 标签
     * @return 插入文章
     */
    Article publishArticle(Article article,String[] item,String[] tags);

    /**
     * 修改Article
     *
     * @param article 文章
     * @param item 文章栏目
     * @param tags 标签
     * @return 插入文章
     */
    Article modifyArticle(Article article,String[] item,String[] tags);


    /**
     * 删除Article
     *
     * @param id 文章id
     * @return void
     */
    void deleteArticle(int id);

    /**
     * 更新Article点击数
     *
     * @param id 文章id
     * @return void
     */
    void updateArticleClick(int id);
}
