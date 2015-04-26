package com.wdxxl.shiro.controller;

import com.wdxxl.shiro.exception.LoginException;
import com.wdxxl.shiro.service.UserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String index() {
        // 转发到登录页面
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String submit(HttpServletRequest request) {
        // 获取表单数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isRememberMe = request.getParameter("rememberMe") != null;

        // 调用登录服务
        try {
            userService.login(username, password, isRememberMe);
        } catch (LoginException e) {
            request.setAttribute("exception", e.getName());
            return index();
        }

        // 重定向到空间页面
        return "redirect:/space";
    }
}
