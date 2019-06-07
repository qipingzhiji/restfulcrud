package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by zhang_htao on 2019/5/30.
 */
@Controller
public class HelloController {

//    @GetMapping(value = {"/","/index.html"})
//    public String index(){
//        return "login";
//    }

    @ResponseBody
    @GetMapping("hello")
    public String hello(String user) {
        return "hello:" + user;
    }


    @RequestMapping("success")
    public String success(Map<String,Object> map) {
        map.put("hello", "你好");
        map.put("login.user", "admin");
        map.put("h1","<h2>这是一个h2标签<h2>");
        map.put("list", Arrays.asList("zhangsan","lisi","wangwu"));
        return "success";
    }
}
