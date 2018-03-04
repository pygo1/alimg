package com.alimg.blog.service.impl;

import com.alimg.blog.dao.ItemDao;
import com.alimg.blog.entity.Article;
import com.alimg.blog.entity.Item;
import com.alimg.blog.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    // 注入Service依赖
    @Autowired
    private ItemDao itemDao;

    public List<Item> getList() {
        List<Item> items;
        items = itemDao.getAllItem();
        return items;
    }

    public List<Article> getArticle(Integer offset, int limit, String item) {
        List<Article> articles = itemDao.selectArticleInItem(offset,limit,item);
        return articles;
    }

    public int getCountbyItem(String item) {
        int count = itemDao.selectArticleCountByItem(item);
        return count;
    }
}
