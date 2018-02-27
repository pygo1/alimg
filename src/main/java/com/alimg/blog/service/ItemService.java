package com.alimg.blog.service;

import com.alimg.blog.entity.Item;

import java.util.List;

public interface ItemService {
    /**
     * 查询所有Item
     *
     * @return
     */
    List<Item> getList();
}
