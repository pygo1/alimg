package com.alimg.blog.dao;

import com.alimg.blog.dto.TagCloudExecution;
import com.alimg.blog.entity.Article;
import com.alimg.blog.entity.Tag;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TagDao {

    /**
     * 插入Tag
     *
     * @param articleId 文章id
     * @param tags 标签名
     * @return
     */
    void insertTag(@Param("article_id") Integer articleId, @Param("names") String[] tags);

    /**
     * 修改Tag
     *
     * @param articleId 文章id
     * @param tags 标签名
     * @return
     */
    void modifyTag(@Param("article_id") Integer articleId, @Param("names") String[] tags);

    /**
     * 删除Tag
     *
     * @param articleId 文章id
     * @return
     */
    void deleteTag(@Param("article_id") Integer articleId);

    /**
     * 查询文章
     *
     * @param offset 查询开始位置
     * @param limit 查询多少条
     * @param tag 标签
     * @return 文章列表
     */
    List<Article> selectArticleInTag(@Param("offset") int offset, @Param("limit") int limit,@Param("tag") String tag);
    /**
     * 查询文章总数
     *
     * @param tag 标签名
     * @return 符合条件标签的文章总数
     */
    int selectArticleCountByTag(@Param("tag") String tag);
    /**
     * 查询标签云
     *
     * @return 所有标签group
     */
    List<TagCloudExecution> selectTagCloud();
}
