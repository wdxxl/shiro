package com.wdxxl.shiro.controller;

import com.wdxxl.shiro.exception.RegisterException;
import com.wdxxl.shiro.service.UserService;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/register")
    public String index() {
        // 转发到注册页面
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public String submit(HttpServletRequest request) {
        // 获取表单数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 封装注册服务所需的字段
        Map<String, String> fieldMap = new HashMap<String, String>();
        fieldMap.put("username", username);
        fieldMap.put("password", password);

        // 调用注册服务
        try {
            userService.register(fieldMap);
        } catch (RegisterException e) {
            request.setAttribute("exception", e.getName());
            return index();
        }

        // 调用登录服务并重定向到空间页面
        userService.login(username, password, false);
        return "redirect:/space";
    }
}
