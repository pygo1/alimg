package com.alimg.blog.service;

import com.alimg.blog.entity.Article;
import com.alimg.blog.entity.Item;
import com.alimg.blog.entity.Tag;

import java.util.List;

public interface ItemService {
    /**
     * 查询所有Item
     *
     * @return
     */
    List<Item> getList();

    /**
     * 查询文章
     *
     * @param offset 查询开始位置
     * @param limit 查询多少条
     * @param item 栏目
     * @return 文章列表
     */
    List<Article> getArticle(Integer offset, int limit, String item);

    /**
     * 查询文章总数
     *
     * @param item 栏目id
     * @return 符合条件栏目的文章总数
     */
    int getCountbyItem(String item);

}
