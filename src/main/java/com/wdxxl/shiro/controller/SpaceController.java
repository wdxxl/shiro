package com.wdxxl.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpaceController {

    @RequestMapping(method = RequestMethod.GET, value = "/space")
    public String index() {
        return "space";
    }
}
