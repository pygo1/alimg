package com.alimg.blog.service;

import com.alimg.blog.entity.Article;
import com.alimg.blog.entity.Item;

import java.util.List;

public interface ItemService {
    /**
     * 查询所有Item
     *
     * @return
     */
    List<Item> getList();

    List<Article> getArticle(Integer offset, int limit, String item);

    int getCountbyItem(String item);
}
