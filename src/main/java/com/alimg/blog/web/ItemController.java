package com.alimg.blog.web;

import com.alimg.blog.dto.Result;
import com.alimg.blog.dto.TagCloudExecution;
import com.alimg.blog.entity.Article;
import com.alimg.blog.entity.Item;
import com.alimg.blog.service.ArticleService;
import com.alimg.blog.service.ItemService;
import com.alimg.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ItemController extends BaseController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ItemService itemService;
    @Autowired
    private TagService tagService;

    @RequestMapping(value = "/i/{item}", method = RequestMethod.GET)
    private String article(@PathVariable("item") String item,Model model) {
        List<Article> topList = articleService.getTopList(0);

        List<Item> items = itemService.getList();

        int articleCount = itemService.getCountbyItem(item);

        List<TagCloudExecution> tags = tagService.getTagCloud();

        List<Article> notice = articleService.getList(0,3,8,"");

        model.addAttribute("itemList", items);
        model.addAttribute("item", item);
        model.addAttribute("articleTopList", topList);
        model.addAttribute("articleCount", articleCount);
        model.addAttribute("tagsCloud", tags);
        model.addAttribute("notice", notice);

        return "page_item";
    }

    @RequestMapping(value = "/page/item/{item}/{page}", method = RequestMethod.POST,produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    private Result<List<Article>> tagArticle(@PathVariable("item") String item, @PathVariable("page") Integer page){

        if (page == null) {
            return new Result<List<Article>>(false,"参数错误");
        }
        try {
            List<Article> articleList = itemService.getArticle(8*(page-1),8,item);

            return new Result<List<Article>>(true,articleList);
        }catch (Exception e){
            return new Result<List<Article>>(false,"查询异常");
        }
    }

}
