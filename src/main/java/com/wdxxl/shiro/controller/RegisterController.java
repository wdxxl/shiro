package com.wdxxl.shiro.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wdxxl.shiro.exception.RegisterException;
import com.wdxxl.shiro.service.UserService;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/register")
    public String index(Model model) {
    	  Map<Integer,String> map=new HashMap<Integer,String>();
          map.put(1, "mapItem 路人甲");
          map.put(2, "mapItem 路人乙");
          map.put(3, "mapItem 路人丙");
          model.addAttribute("roleList", map);
        // 转发到注册页面
        return "register";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/register")
    public String submit(HttpServletRequest request,Model model) {
        // 获取表单数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 调用注册服务
        try {
            userService.register(username,password);
        } catch (RegisterException e) {
            request.setAttribute("exception", e.getName());
            return index(model);
        }

        // 调用登录服务并重定向到空间页面
        userService.login(username, password, false);
        return "redirect:/space";
    }
}
