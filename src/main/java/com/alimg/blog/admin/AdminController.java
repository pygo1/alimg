package com.alimg.blog.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alimg.blog.dto.DeleteExecution;
import com.alimg.blog.dto.Result;

import com.alimg.blog.entity.Article;
import com.alimg.blog.entity.Item;

import com.alimg.blog.entity.User;

import com.alimg.blog.service.ArticleService;
import com.alimg.blog.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.List;

@Controller
@RequestMapping(value = "/admin")
public class AdminController extends BaseController {

    @Autowired
    private ArticleService articleService;

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

        List<Article> articleList = articleService.getList(0,8,0,"");

        int articleCount = articleService.getArticleCount(0,"");

        List<Item> items = itemService.getList();

        model.addAttribute("itemList", items);
        model.addAttribute("articleCount", articleCount);
        model.addAttribute("articleList", articleList);

        return "admin/article";
    }

    @RequestMapping(value = "/article/modify/{id}", method = RequestMethod.GET)
    private String modifyArticle(@PathVariable("id") Integer id, Model model) {

        List<Item> items = itemService.getList();

        Article article = articleService.getArticle(id);

        model.addAttribute("article", article);
        model.addAttribute("itemList", items);
        return "admin/modifyArticle";
    }

    //ajax
    @RequestMapping(value = "/page/article/count/{item}", method = RequestMethod.POST,produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    private Result<Integer> countArticle(@PathVariable("item") Integer item,@RequestParam("search") String search){
        if(item == null){
            return new Result<Integer>(false,"参数错误");
        }
        try{
            int articleCount = articleService.getArticleCount(item,search);
            return new Result<Integer>(true,articleCount);
        }catch (Exception e){
            return new Result<Integer>(false,"查询异常");
        }
    }

    @RequestMapping(value = "/page/article/{page}", method = RequestMethod.POST,produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    private Result<List<Article>> pageArticle(@PathVariable("page") Integer page,@RequestParam("item") int item,@RequestParam("search") String search){

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

    @RequestMapping(value = "/publish/article", method = RequestMethod.POST,produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    private Result<Article> publish(HttpServletRequest req, HttpServletResponse res) throws ParseException {
        Article article = new Article();

        String dataStr = req.getParameter("data");
        JSONObject jsonObj = JSON.parseObject(dataStr);
        System.out.println(jsonObj);
        JSONArray itemObj = jsonObj.getJSONArray("item");
        List<String> itemList = new ArrayList<String>();

        for (int i= 0;i < itemObj.size();i++){
            itemList.add(itemObj.getString(i));
        }

        String[] item = itemList.toArray(new String[itemList.size()]);
        String tag = jsonObj.getString("tag");
        String[] tags = tag.split(",");

        article.setTitle(jsonObj.getString("title"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        article.setCreateTime(sdf.parse(jsonObj.getString("createTime")));
        article.setLevel(jsonObj.getString("level"));
        article.setContent(jsonObj.getString("content"));

        User user = (User)req.getSession().getAttribute("user");
        article.setAuthorId(user.getId());

        try {
            article = articleService.publishArticle(article,item,tags);
            return new Result<Article>(true,article);
        }catch (Exception e){
            return new Result<Article>(false,"发布文章出错！");
        }
    }

    @RequestMapping(value = "/article/modify/{id}", method = RequestMethod.POST,produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    private Result<Article> modifyArticle(HttpServletRequest req, HttpServletResponse res,@PathVariable("id") int id) throws ParseException {

        Article article = new Article();
        article.setId(id);

        String dataStr = req.getParameter("data");
        JSONObject jsonObj = JSON.parseObject(dataStr);
        JSONArray itemObj = jsonObj.getJSONArray("item");

        List<String> itemList = new ArrayList<String>();
        for (int i= 0;i < itemObj.size();i++){
            itemList.add(itemObj.getString(i));
        }
        String[] item = itemList.toArray(new String[itemList.size()]);
        String tag = jsonObj.getString("tag");
        String[] tags = tag.split(",");

        article.setTitle(jsonObj.getString("title"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        article.setCreateTime(sdf.parse(jsonObj.getString("createTime")));
        article.setLevel(jsonObj.getString("level"));
        article.setContent(jsonObj.getString("content"));

        User user = (User)req.getSession().getAttribute("user");
        article.setAuthorId(user.getId());
        article = articleService.modifyArticle(article,item,tags);
        try {

            article = articleService.modifyArticle(article,item,tags);
            return new Result<Article>(true,article);
        }catch (Exception e){
            return new Result<Article>(false,"发布文章出错！");
        }
    }

    @RequestMapping(value = "/article/delete/{id}", method = RequestMethod.POST,produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    private Result<DeleteExecution> deleteArticle(@PathVariable("id") int id){
        try {
            articleService.deleteArticle(id);
            DeleteExecution deleteExecution = new DeleteExecution();
            deleteExecution.setState(1);
            deleteExecution.setStateInfo("删除成功！");
            return new Result<DeleteExecution>(true,deleteExecution);
        }catch (Exception e){
            return new Result<DeleteExecution>(false,"删除文章出错！");
        }
    }

}
