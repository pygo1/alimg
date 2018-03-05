package com.alimg.blog.web;

import com.alimg.blog.dto.Result;
import com.alimg.blog.dto.TagCloudExecution;
import com.alimg.blog.entity.Article;
import com.alimg.blog.entity.Item;
import com.alimg.blog.service.ArticleService;
import com.alimg.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TagController extends BaseController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/t/{tag}", method = RequestMethod.GET)
    private String article(@PathVariable("tag") String tag,Model model) {
        List<Article> topList = articleService.getTopList(0);

        List<Item> items = itemService.getList();

        //List<Article> articles = tagService.getArticle(0,8,tag);
        int articleCount = tagService.getCountbyTag(tag);

        List<TagCloudExecution> tags = tagService.getTagCloud();

        List<Article> notice = articleService.getList(0,3,8,"");


        model.addAttribute("itemList", items);
        model.addAttribute("tag", tag);
        model.addAttribute("articleTopList", topList);

        model.addAttribute("articleCount", articleCount);

        model.addAttribute("tagsCloud", tags);
        model.addAttribute("notice", notice);

        return "page";
    }

    @RequestMapping(value = "/page/tag/{tag}/{page}", method = RequestMethod.POST,produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    private Result<List<Article>> tagArticle(@PathVariable("tag") String tag, @PathVariable("page") Integer page){

        if (page == null) {
            return new Result<List<Article>>(false,"参数错误");
        }
        try {
            List<Article> articleList = tagService.getArticle(8*(page-1),8,tag);

            return new Result<List<Article>>(true,articleList);
        }catch (Exception e){
            return new Result<List<Article>>(false,"查询异常");
        }
    }

}
