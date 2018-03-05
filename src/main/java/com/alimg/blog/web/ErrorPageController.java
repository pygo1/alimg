package com.alimg.blog.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorPageController {

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    private String error404(){

        return "errorPage/404";
    }
}
