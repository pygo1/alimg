package com.alimg.blog.admin;

import com.alimg.blog.dto.LoginExecution;
import com.alimg.blog.dto.Result;
import com.alimg.blog.enums.LoginStateEnum;
import com.alimg.blog.exception.NoUserException;
import com.alimg.blog.service.ArticleService;
import com.alimg.blog.service.UserService;
import com.alimg.blog.web.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/login")
public class LoginController extends BaseController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserService UserService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    private String login() {

        return "admin/login";
    }

    @RequestMapping(value = "/checkUser", method = RequestMethod.POST,produces = {
            "application/json; charset=utf-8" })
    @ResponseBody

    private Result<LoginExecution> checkUser(@RequestParam("email") String email, @RequestParam("password") String password,HttpSession httpSession) {
        if (email == null || email.equals("")){
            return new Result<LoginExecution>(false,"用户名不能为空");
        }else if (password == null || password.equals("")){
            return new Result<LoginExecution>(false,"密码不能为空");
        }
        LoginExecution LoginExecution = null;

        try {
            LoginExecution = UserService.checkUser(email,password);
            httpSession.setAttribute("user", LoginExecution.getUser());
        }catch (NoUserException e1){
            LoginExecution = new LoginExecution(email, LoginStateEnum.NO_USER);
        }
        return new Result<LoginExecution>(true, LoginExecution);
    }

}
