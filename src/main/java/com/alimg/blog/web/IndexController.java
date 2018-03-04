package com.alimg.blog.web;

import com.alimg.blog.dto.Result;
import com.alimg.blog.entity.Article;
import com.alimg.blog.entity.Item;
import com.alimg.blog.entity.User;
import com.alimg.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController extends BaseController {

    @Autowired
    private ArticleService articleService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    private String list(HttpServletRequest req,Model model) {
        List<Article> list = articleService.getList(0,8,0,"");

        List<Article> topList = articleService.getTopList(0);

        List<Item> items = itemService.getList();

        int articleCount = articleService.getArticleCount(0,"");

        User user = (User)req.getSession().getAttribute("user");

        model.addAttribute("itemList", items);
        model.addAttribute("articleList", list);
        model.addAttribute("articleTopList", topList);

        model.addAttribute("articleCount", articleCount);
        return "index";
    }

    @RequestMapping(value = "/page/article/{page}", method = RequestMethod.POST,produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    private Result<List<Article>> pageArticle(@PathVariable("page") Integer page, @RequestParam("item") int item, @RequestParam("search") String search){

        if (page == null) {
            return new Result<List<Article>>(false,"参数错误");
        }
        try {
            List<Article> articleList = articleService.getList(8*(page-1),8,item,search);

            return new Result<List<Article>>(true,articleList);
        }catch (Exception e){
            return new Result<List<Article>>(false,"查询异常");
        }
    }
}
