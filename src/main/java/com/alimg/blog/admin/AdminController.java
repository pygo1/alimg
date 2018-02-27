package com.alimg.blog.admin;

import com.alimg.blog.dto.Result;
import com.alimg.blog.dto.LoginExecution;
import com.alimg.blog.entity.Article;
import com.alimg.blog.entity.Item;
import com.alimg.blog.entity.Tag;
import com.alimg.blog.entity.User;
import com.alimg.blog.enums.LoginStateEnum;
import com.alimg.blog.exception.NoUserException;
import com.alimg.blog.service.ArticleService;
import com.alimg.blog.service.UserService;
import com.alimg.blog.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService UserService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    private String login() {

        return "admin/index";
    }
    @RequestMapping(value = "/postArticle", method = RequestMethod.GET)
    private String postArticle(Model model) {
        List<Item> items = itemService.getList();
        model.addAttribute("itemList", items);
        return "admin/postArticle";
    }

    @RequestMapping(value = "/article", method = RequestMethod.GET)
    private String article(Model model) {
        List<Article> articleList = articleService.getList(0,8);
        System.out.println(articleList);
        int articleCount = articleService.getArticleCount();

        List<Item> items = itemService.getList();
        model.addAttribute("itemList", items);
        model.addAttribute("articleCount", articleCount);
        model.addAttribute("articleList", articleList);
        return "admin/article";
    }
    @RequestMapping(value = "/page/article/{page}", method = RequestMethod.POST,produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    private Result<List<Article>> pageArticle(@PathVariable("page") Integer page){
        if (page == null) {
            return new Result<List<Article>>(false,"参数错误");
        }
        try {
            List<Article> articleList = articleService.getList(8*(page-1),8);
            System.out.println(articleList);
            return new Result<List<Article>>(true,articleList);
        }catch (Exception e){
            return new Result<List<Article>>(false,"查询异常");
        }
    }


    @RequestMapping(value = "/publish/article", method = RequestMethod.POST,produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    private Result<Article> publish(HttpServletRequest req, HttpServletResponse res) throws ParseException {
        Article article = new Article();
        int item = Integer.parseInt(req.getParameter("item"));
        String tag = req.getParameter("tag");
        String[] tags = tag.split(",");

        article.setTitle(req.getParameter("title"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        article.setCreateTime(sdf.parse(req.getParameter("createTime")));
        article.setLevel(req.getParameter("level"));
        article.setContent(req.getParameter("content"));

        User user = (User)req.getSession().getAttribute("user");
        article.setAuthorId(user.getId());
        try {
            article = articleService.publishArticle(article,item,tags);
            return new Result<Article>(true,article);
        }catch (Exception e){
            return new Result<Article>(false,"发布文章出错！");
        }
    }

}
