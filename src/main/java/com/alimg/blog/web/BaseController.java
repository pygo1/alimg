package com.alimg.blog.web;

import com.alimg.blog.entity.Item;
import com.alimg.blog.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BaseController {

    @Autowired
    protected ItemService itemService;

    public BaseController() {

    }
}
