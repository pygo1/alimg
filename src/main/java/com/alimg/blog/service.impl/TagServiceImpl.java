package com.alimg.blog.service.impl;

import com.alimg.blog.dao.ItemDao;
import com.alimg.blog.dao.TagDao;
import com.alimg.blog.dto.TagCloudExecution;
import com.alimg.blog.entity.Article;
import com.alimg.blog.entity.Item;
import com.alimg.blog.entity.Tag;
import com.alimg.blog.service.ItemService;
import com.alimg.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    // 注入Service依赖
    @Autowired
    private TagDao tagDao;

    public List<Tag> getList() {
        return null;
    }

    public List<Article> getArticle(Integer offset, int limit,String tag) {
        List<Article> articles = tagDao.selectArticleInTag(offset,limit,tag);
        return articles;
    }

    public int getCountbyTag(String tag) {
        int count = tagDao.selectArticleCountByTag(tag);
        return count;
    }

    public List<TagCloudExecution> getTagCloud() {
        List<TagCloudExecution> tags = tagDao.selectTagCloud();
        return tags;
    }

}
