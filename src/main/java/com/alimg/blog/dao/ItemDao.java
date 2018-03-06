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

    /**
     * 插入Item
     *
     * @param articleId 文章id
     * @param item_id 栏目id
     * @return
     */
    void  insertHasItem(@Param("article_id") int articleId, @Param("item_id") String[] item_id);

    /**
     * 修改Item
     *
     * @param articleId 文章id
     * @param item_id 栏目id
     * @return
     */
    void  modifyHasItem(@Param("article_id") int articleId, @Param("item_id") String[] item_id);

    /**
     * 删除Item
     *
     * @param articleId 文章id
     * @return
     */
    void  deleteItem(@Param("article_id") int articleId);

    /**
     * 查询文章
     *
     * @param offset 查询开始位置
     * @param limit 查询多少条
     * @param item 栏目
     * @return 文章列表
     */
    List<Article> selectArticleInItem(@Param("offset") int offset, @Param("limit") int limit, @Param("item") String item);

    /**
     * 查询文章总数
     *
     * @param item 栏目id
     * @return 符合条件栏目的文章总数
     */
    int selectArticleCountByItem(@Param("item") String item);
}
