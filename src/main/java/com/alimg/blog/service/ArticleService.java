package com.alimg.blog.service;

import com.alimg.blog.entity.Article;

import java.util.List;

public interface ArticleService {
    /**
     * 查询所有Article
     *
     * @return
     */
    List<Article> getList(Integer offset, int limit);

    int getArticleCount();

    Article publishArticle(Article article,int item,String[] tags);
}
