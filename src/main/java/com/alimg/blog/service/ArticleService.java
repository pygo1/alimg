package com.alimg.blog.service;

import com.alimg.blog.entity.Article;

import java.util.List;

public interface ArticleService {
    /**
     * 查询所有Article
     *
     * @return
     */
    List<Article> getList(Integer offset, int limit,int item ,String search);

    Article getArticle(Integer id);

    int getArticleCount(int item,String search);

    Article publishArticle(Article article,String[] item,String[] tags);

    Article modifyArticle(Article article,String[] item,String[] tags);

    void deleteArticle(int id);
}
