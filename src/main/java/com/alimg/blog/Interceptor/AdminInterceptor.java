package com.alimg.blog.Interceptor;

import com.alimg.blog.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.regex.Pattern;

public class AdminInterceptor implements HandlerInterceptor {

    //对admin路由验证是否登录
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String url = httpServletRequest.getRequestURL().toString();
        if( !Pattern.matches(".*/admin(/.*)?",url)){
            return true;
        }
        try {
            User user = (User) httpServletRequest.getSession().getAttribute("user");
            if (user == null){
                //httpServletRequest.getRequestDispatcher("/404").forward(httpServletRequest,httpServletResponse);
                httpServletResponse.sendRedirect("/login");
                return false;
            }
        }catch (Exception e){
            //httpServletRequest.getRequestDispatcher("/500").forward(httpServletRequest,httpServletResponse);
            httpServletResponse.sendRedirect("/login");
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        //System.out.println("执行postHandle方法");

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //System.out.println("执行afterCompletion方法");

    }
}
