package com.wdxxl.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {

    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String index() {
        // 获取当前用户并进行登出操作
        Subject user = SecurityUtils.getSubject();
        user.logout();

        // 重定向到首页
        return "redirect:/";
    }
}
