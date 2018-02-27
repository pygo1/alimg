package com.alimg.blog.web;

import com.alimg.blog.entity.Article;
import com.alimg.blog.entity.Item;
import com.alimg.blog.entity.User;
import com.alimg.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController extends BaseController {

    @Autowired
    private ArticleService articleService;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    private String list(HttpServletRequest req,Model model) {
        List<Article> list = articleService.getList();
        System.out.println(list.size());
        List<Item> items = itemService.getList();
        User user = (User)req.getSession().getAttribute("user");
        System.out.println(user);
        model.addAttribute("itemList", items);
        model.addAttribute("articleList", list);
        return "index";
    }
}
