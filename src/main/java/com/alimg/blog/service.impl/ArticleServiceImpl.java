package com.alimg.blog.service.impl;

import com.alimg.blog.dao.ArticleDao;
import com.alimg.blog.dao.ItemDao;
import com.alimg.blog.dao.TagDao;
import com.alimg.blog.entity.Article;
import com.alimg.blog.exception.NoUserException;
import com.alimg.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    // 注入Service依赖
    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private TagDao tagDao;

    public List<Article> getList(Integer offset, int limit,int item) {
        List<Article> articles;
        articles = articleDao.queryAll(offset,limit,item);
        return articles;
    }

    public Article getArticle(Integer id) {
        Article article = articleDao.selectArticle(id);
        return article;
    }

    public int getArticleCount(int item) {
        int count = articleDao.selectArticleCount(item);
        return count;
    }

    @Transactional
    public Article publishArticle(Article article,String[] item,String[] tags) {
        try {
            articleDao.insertArticle(article);
            int articleId = article.getId();

            itemDao.insertHasItem(articleId,item);

            tagDao.insertTag(articleId,tags);
            return article;
        }catch (Exception e){
            throw new NoUserException(e.getMessage());
        }
    }
    @Transactional
    public Article modifyArticle(Article article, String[] item, String[] tags) {
        try {
            articleDao.modifyArticle(article);
            int articleId = article.getId();

            itemDao.deleteItem(articleId);
            itemDao.modifyHasItem(articleId,item);

            tagDao.deleteTag(articleId);
            tagDao.modifyTag(articleId,tags);
            return article;
        }catch (Exception e){
            throw new NoUserException(e.getMessage());
        }
    }
}
