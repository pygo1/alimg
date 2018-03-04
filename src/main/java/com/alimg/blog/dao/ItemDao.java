package com.alimg.blog.dao;

import com.alimg.blog.entity.Article;
import com.alimg.blog.entity.Item;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ItemDao {
    /**
     * 查询所有Item
     *
     * @return
     */
    List<Item>  getAllItem();

    void  insertHasItem(@Param("article_id") int articleId, @Param("item_id") String[] item_id);

    void  modifyHasItem(@Param("article_id") int articleId, @Param("item_id") String[] item_id);

    void  deleteItem(@Param("article_id") int articleId);

    List<Article> selectArticleInItem(@Param("offset") int offset, @Param("limit") int limit, @Param("item") String item);

    int selectArticleCountByItem(@Param("item") String item);
}
