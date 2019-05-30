package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhang_htao on 2019/5/30.
 */
@RestController
public class HelloController {

    @GetMapping("hello")
    public String hello(String user) {
        return "hello:" + user;
    }
}
